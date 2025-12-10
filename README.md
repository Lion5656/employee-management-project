## Employee Management System (EMP)

A comprehensive backend solution for managing enterprise employee data, built with **Spring Boot 3** and **Java 21**. This project utilizes a **multi-module Maven architecture** to implement five use cases: *login, employee, department, attendance record, and operational logs.*

Key features include:
* **User Authentication**: Secure login system using JWT.
* **Employee & Dept Management**: CRUD operations for managing staff and organizational structures.
* **Attendance Tracking**: Query employee attendance.
* **Operation Logging**: Automated system logging using AOP.
* **Reports & Analytics**: Show data reports for employee statistics.

## Requirements

To run this project locally, you will need the following environment installed on your machine:

-   **Java Development Kit (JDK)**: Version 21 or higher.
-   **Database**: MySQL (or compatible SQL database configured in `application.yml`).
-   **Git**: For version control.

You do **not** need to install Maven manually, as this project includes the Maven Wrapper (`mvnw`).

## Usage

Follow these steps to build and run the application:

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/YourUsername/emp-management-project.git](https://github.com/YourUsername/emp-management-project.git)
    cd emp-management-project
    ```

2.  **Build the project**
    Use the included Maven Wrapper to compile and package the application (skipping tests for faster build):
    ```bash
    ./mvnw clean package -DskipTests
    ```
    *(For Windows CMD, use `mvnw clean package -DskipTests`)*

3.  **Run the application**
    Navigate to the main module's target directory and execute the jar file:
    ```bash
    java -jar emp-management-parent/employee-management/target/employee-management-1.0-SNAPSHOT.jar
    ```
    *(Note: Replace `1.0-SNAPSHOT` with your actual version if different)*

For more details on API endpoints, please refer to the controller source code or API documentation (if available).

## Useful Resources

Include here any other links that are relevant for the project:

-   [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
-   [Project Lombok](https://projectlombok.org/) - Reduces boilerplate code.
-   [MyBatis Framework](https://mybatis.org/mybatis-3/) - SQL mapping framework.
-   [JWT.io](https://jwt.io/) - Introduction to JSON Web Tokens.