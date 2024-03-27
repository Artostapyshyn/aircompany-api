# Air Company API

## Overview
The Air Company API is a Spring Boot application that provides endpoints for managing airline system functionalities. This README provides step-by-step instructions for setting up and running the application using Docker Compose.

## Prerequisites
- Docker
- Docker Compose

## Setup Instructions

### 1. Clone the Repository
``` git clone https://github.com/your-username/air-company-api.git ```

``` cd air-company-api  ```

### 2. Build Docker Images
Run the following command to build the Docker images for the Spring Boot application:

```docker-compose build ```


### 3. Start Containers
Start the Docker containers using Docker Compose:

```docker-compose up ```

### 4. Access the API
Once the containers are up and running, you can access the API at the:

`http://localhost:8080/api/v1/`

### 5. Shutdown Instructions
To stop the Docker containers and remove the network:

```docker-compose down```

### Additional Notes
- The MySQL database is automatically created and configured when the Docker containers are started.
- Make sure Docker and Docker Compose are installed and running before executing the above commands.
