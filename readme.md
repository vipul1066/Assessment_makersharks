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
- MySQL (or any other database of your choice)

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

## API Documentation

### Register User

**POST** `/api/user/register`

- **Request Body:**

    ```json
    {
        "userName": "Aditya Vardhan",
        "email": "aditya.vardham@gmail.com",
        "password": "vardhan@1707",
        "phoneNumber": "9431568905",
        "address": "New chandmari, Motihari, Bihar"
    }
    ```

- **Response:**

    - **Success: `201 Created`**

        ```json
        {
            "userId": "9a9f7521-27bf-4bad-a1f8-28b42db99252",
            "userName": "Pratush Singh",
            "email": "prayushsingh879@gmail.com",
            "password": "$2a$10$tW4RUYmY9x9yq1IkE6xGxe9r3VhBm0vTup0Sx2kBxQChhuL5Vg8c2",
            "phoneNumber": "8340884689",
            "address": "Hpcl Society sectorr-pi"
        }
        ```

    - **Failure: `400 Bad Request`**

        ```json
        {
            "error": "User already exists using this email"
        }
        ```

### Fetch Users

**GET** `/api/user/fetch`

- **Response:**

    - **Success: `200 OK`**

        ```json
        [
            {
                "userId": "f8cc4a6d-e415-4ad8-a799-03d7947c0570",
                "userName": "Aditya Vardhan",
                "email": "aditya.vardham@gmail.com",
                "password": "$2a$10$yd.MajHhcjTZec2T2bThbOWZhPOsMycjcpzyYI/DlZ2Cnblg2CRxG",
                "phoneNumber": "9431568905",
                "address": "New chandmari, Motihari, Bihar"
            },
            {
                "userId": "ae873bc7-8226-4770-8f7d-68b4e803cc98",
                "userName": "Nisha Singh",
                "email": "nisha.singh879@gmail.com",
                "password": "$2a$10$skzznBh97.2Wiq110Hiw6.4UIMMV9zJiR/oGUeGNaIxFhd6Fh6hRS",
                "phoneNumber": "9125136598",
                "address": "Taramandal, Gorakhpur"
            },
            {
                "userId": "92f973cd-b485-42b3-8a12-10ed0df8e75b",
                "userName": "Atul Kumar Singh",
                "email": "atulsingh5435135@gmail.com",
                "password": "$2a$10$gGweIe1Y2DpXms2DoalK9.K7Stpyvng1hPIRZyl5iE3.WUjqznkr.",
                "phoneNumber": "8325136598",
                "address": "Varanasi, Uttar Pradesh"
            }
        ]
        ```

### Fetch User by ID

**GET** `/api/user/fetch/id/{userId}`

- **Response:**

    - **Success: `200 OK`**

        ```json
        {
            "userId": "ae873bc7-8226-4770-8f7d-68b4e803cc98",
            "userName": "Nisha Singh",
            "email": "nisha.singh879@gmail.com",
            "password": "$2a$10$skzznBh97.2Wiq110Hiw6.4UIMMV9zJiR/oGUeGNaIxFhd6Fh6hRS",
            "phoneNumber": "9125136598",
            "address": "Taramandal, Gorakhpur"
        }
        ```

    - **Failure: `404 Not Found`**

        ```json
        {
            "error": "User not found"
        }
        ```

### Fetch User by Email

**GET** `/api/user/fetch/email/{email}`

- **Response:**

    - **Success: `200 OK`**

        ```json
        {
            "userId": "92f973cd-b485-42b3-8a12-10ed0df8e75b",
            "userName": "Atul Kumar Singh",
            "email": "atulsingh5435135@gmail.com",
            "password": "$2a$10$gGweIe1Y2DpXms2DoalK9.K7Stpyvng1hPIRZyl5iE3.WUjqznkr.",
            "phoneNumber": "8325136598",
            "address": "Varanasi, Uttar Pradesh"
        }
        ```

    - **Failure: `404 Not Found`**

        ```json
        {
            "error": "User not found"
        }
        ```

## CURL Commands

### Register User

```sh
curl -X POST http://localhost:8080/api/user/register \
-H "Content-Type: application/json" \
-d '{
  "userName": "Aditya Vardhan",
  "email": "aditya.vardham@gmail.com",
  "password": "vardhan@1707",
  "phoneNumber": "9431568905",
  "address": "New chandmari, Motihari, Bihar"
}'
