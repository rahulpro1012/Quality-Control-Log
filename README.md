
# Quality-Log-Control Application

# Description
This project is designed to demonstrate logging functionality in a Spring Boot application. It includes implementations for logging messages to different log files based on log level, and a query interface for searching logs by various criteria.

# Features
<ul>
  <li>Log messages to different log files based on log level (error, success, info).</li>
  <li>Search logs by level, log message, timestamp, and source.</li>
  <li>Filter logs within specific date ranges.</li>
  <li>Scalable and efficient logging implementation.</li>
  <li>Customizable log file paths.</li>
  </ul>
Technologies Used
Java
Spring Boot
Spring Web
SLF4J (Simple Logging Facade for Java)
Logback (Logging framework)
Setup Instructions
Clone the repository to your local machine.
Make sure you have Java and Maven installed.
Build the project using Maven: mvn clean install.
Run the Spring Boot application: mvn spring-boot:run.
Access the query interface at http://localhost:8080.
Usage
Use the provided API endpoints to log messages and search logs.
Customize the log file paths and configurations in the application.properties file.
Explore the codebase to understand the logging implementation and query interface.
Sample Queries
Here are some sample queries you can execute:

Search for all logs with the level set to "error".
Search for logs with the message containing a specific term.
Filter logs between specific timestamp ranges.
