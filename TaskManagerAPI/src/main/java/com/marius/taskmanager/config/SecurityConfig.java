package com.marius.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict /admin/** to admin role
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // Restrict /user** to USER or ADMIN roles
                .anyRequest().authenticated() // All other requests require authentication
            )
            .oauth2Login(oauth -> oauth
                .loginPage("/login") // Custom login page
                .userInfoEndpoint(userInfo -> userInfo
                    .oidcUserService(new OidcUserService()) // Handle user information for Google OAuth2
                )
            );
        return http.build();
    }
}
