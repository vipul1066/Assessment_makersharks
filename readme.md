# MakerSharks API

This is a simple RESTful API built with Spring Boot for user registration and fetching user details.

## API Endpoints

1. **Register User** - `/api/user/register` [POST]
2. **Fetch Users** - `/api/user/fetch` [GET]
3. **Fetch User by ID** - `/api/user/fetch/id/{userId}` [GET]
4. **Fetch User by Email** - `/api/user/fetch/email/{email}` [GET]

## Requirements

- Java 17
- Maven
- MySQL

## Project Setup

1. **Clone the repository:**

    ```sh
    git clone https://github.com/anandpiyush1521/Makersharks-Assessment.git
    cd Makersharks-Assessment
    ```

2. **Update the `application.yml` file with your database configuration:**

    ```yaml
    spring:
        datasource:
            url: jdbc:mysql://localhost:3306/makersharks
            username: root
            password: 
            driver-class-name: com.mysql.cj.jdbc.Driver
        
        jpa:
            hibernate:
                ddl-auto: update
            show-sql: true
    ```

3. **Build and run the application:**

    ```sh
    mvn spring-boot:run
    ```

4. **Access Swagger UI for API documentation:**

    ```
    http://localhost:8080/swagger-ui/
    ```

