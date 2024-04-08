# Enterprise Device Management System

This project provides a comprehensive solution for managing and assigning company devices (such as smartphones, tablets, and laptops) to employees, using Spring Boot for the backend and a relational database for data persistence. It enables CRUD operations on employees and devices, manages the assignment status of devices, and supports profile image uploads for employees.

## Features

- **Employee Management**: Create, read, update, and delete employee information, including username, first name, last name, and email.
- **Device Management**: Administer devices with the ability to assign them to employees, mark them as available, under maintenance, or decommissioned.
- **Device Assignment**: Allows the assignment of devices to employees through a specific endpoint.
- **Image Upload**: Enables employees to upload their profile images.


## Technologies Used

- **Spring Boot**: Framework for developing Java applications with RESTful web services.
- **Relational Database** (e.g., MySQL, PostgreSQL): For persistence of employee and device data.
- **Hibernate**: ORM used to facilitate integration between Java and the relational database.
- **Spring Data JPA**: To simplify data access in the database.
- **Spring Web MVC**: To build and manage RESTful web services.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes


## Prerequisites

- JDK 1.8 or higher
- Maven 3.3+
- An instance of a relational database (MySQL/PostgreSQL)
- A Cloudinary account for image uploads


## Setup

As this project is solely a backend, there is no frontend available to execute a run. All endpoint testing has been conducted using Postman.

1. **Clone the Repository**: Clone the repository to a local directory using the following command:

``` git clone https://github.com/your-username/enterprise-device-management-system.git ```

1. **Configure Environment Variables**:

  - Create a file named `application.properties` in the project's main directory.
  - Add the following variables to the `application.properties` file and replace the variable values with your credentials:

  ```spring.datasource.url=jdbc:your_database_url
  spring.datasource.username=your_database_username
  spring.datasource.password=db_password
  spring.jpa.hibernate.ddl-auto=update

  cloudinary.cloud_name=cloudinary_name
  cloudinary.api_key=cloudinary_key
  cloudinary.api_secret=cloudinary_secret```

  Be sure to replace `your_database_url`, `your_database_username`, `db_password`, `cloudinary_name`, `cloudinary_key`, and `cloudinary_secret` with your actual data.

2. Compile and Run the Application


## Usage

Once the service is running, you can interact with it using any HTTP client (such as Postman or curl) to send requests to the various endpoints exposed by the service.

For detailed information on the available endpoints and their usage, please refer to the sections below.

## Error Handling
The service handles various error situations, returning appropriate HTTP status codes and error messages for invalid data, not found resources, or constraint violations.

## Endpoint Documentation
### Device Endpoints

**Save a Device**:

  - **Method**: POST
  - **URL**: /devices
  - **Description**: Create a new device.
  - **Request Body**: JSON object representing the new device.
  - **Response**: Returns the newly created device.

**Get All Devices**:

  - **Method**: GET
  - **URL**: /devices
  - **Description**: Retrieves all devices in the system.
  - **Query** Parameters:
    - `page` (optional): Desired page number (default: 0)
    - `size` (optional): Page size (default: 15)
    - `orderBy` (optional): Field to order devices by (default: id)

**Get a Device by ID**:

- **Method**: GET
- **URL**: /devices/{id}
- **Description**: Retrieves a specific device by its ID.

**Update a Device by ID**:

- **Method**: PUT
- **URL**: /devices/{id}
- **Description**: Updates information for an existing device.
- **Request Body**: JSON object representing the new device information.
- **Response**: Returns the updated device.

**Delete a Device by ID**:

- **Method**: DELETE
- **URL**: /devices/{id}
- **Description**: Deletes a device from the system.
- **Employee** Endpoints

**Save an Employee**:

- **Method**: POST
- **URL**: /employees
- **Description**: Creates a new employee.
- **Request Body**: JSON object representing the new employee.
- **Response**: Returns the newly created employee.

**Get All Employees**:

- **Method**: GET
- **URL**: /employees
- **Description**: Retrieves all employees in the system.
- **Query** Parameters:
  - `page` (optional): Desired page number (default: 0)
  - `size` (optional): Page size (default: 15)
  - `orderBy` (optional): Field to order employees by (default: id)

**Get an Employee by ID**:

- **Method**: GET
- **URL**: /employees/{id}
- **Description**: Retrieves a specific employee by their ID.

**Update an Employee by ID**:

- **Method**: PUT
- **URL**: /employees/{id}
- **Description**: Updates information for an existing employee.
- **Request Body**: JSON object representing the new employee information.
- **Response**: Returns the updated employee.

**Upload a Profile Image for an Employee**:

- **Method**: POST
- **URL**: /employees/{id}/uploadImg
- **Description**: Uploads a profile image for a specific employee.
- **Parameters**:
  - `id`: Employee ID.
  - `profileImg`: Image file to upload.
  - `Response`: Returns the employee with the updated profile image.

**Delete an Employee by ID**:

- **Method**: DELETE
- **URL**: /employees/{id}
- **Description**: Deletes an employee from the system.

## Acknowledgments
Thank you for visiting and exploring this project! If you have any questions or feedback, feel free to reach out.
