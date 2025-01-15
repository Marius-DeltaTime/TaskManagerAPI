
# Task Manager API

![License](https://img.shields.io/badge/license-MIT-green)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

## Introduction

A simple task manager API built using Spring Boot and secured with Google OAuth2 authentication. The API allows users to manage tasks with basic CRUD operations (Create, Read, Update, Delete) and integrates with a MySQL database for persistent data storage.

This project serves as an introduction to Spring Boot, OAuth2 integration, MySQL database management, and building secure APIs.

## Features

- **OAuth2 Authentication**: Users can authenticate using their Google accounts.
- **CRUD Operations**: Allows users to create, read, update, and delete tasks.
- **MySQL Database**: The application uses MySQL for data persistence.
- **Spring Boot**: The application is built using the Spring Boot framework, leveraging Spring Data JPA for database interaction.

## Requirements

- Java 17 or higher
- Spring Boot 3.x
- MySQL 8.x or a MySQL-compatible database (e.g., MariaDB)
- Gradle (for building the project)

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/Marius-DeltaTime/TaskManagerAPI.git
cd TaskManagerAPI
```

### 2. Set up MySQL Database

1. Install MySQL and set up a database (if you haven't already).
2. Create a database named `task_manager_db` (or change the name in `application.properties`).
3. Update `application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
spring.datasource.username=root
spring.datasource.password=<your_password>
spring.jpa.hibernate.ddl-auto=update
```

### 3. Set up Google OAuth2

1. Create a Google Developer project and enable OAuth2 authentication.
2. Obtain your **client ID** and **client secret** from the Google API console.
3. Add the following to your `application.properties`:

```properties
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
spring.security.oauth2.client.registration.google.redirect-uri=http://localhost:8080/login/oauth2/code/{registrationId}
```

### 4. Build and Run the Application

1. Run the following command to build the project:

```bash
./gradlew clean build
```

2. Start the Spring Boot application:

```bash
./gradlew bootRun
```

3. Open the application in your browser at `http://localhost:8080`.

### 5. Testing the API

Once the app is running, you can test the OAuth2 authentication and task management endpoints.

- **OAuth2 Login**: Go to `/login` and authenticate using Google.
- **CRUD Endpoints**: You can perform CRUD operations on tasks via REST endpoints.

