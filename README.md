
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

# Technologies Used
<ul>
  <li>Java</li>
  <li>Spring Boot</li>
  <li>Spring Web</li>
  <li>SLF4J (Simple Logging Facade for Java)</li>
  <li>Logback (Logging framework)</li>
</ul>

# Setup Instructions
<ul>
  <li>Clone the repository to your local machine.</li>
  <li>Make sure you have Java and Maven installed.</li>
  <li>Build the project using Maven: mvn clean install.</li>
  <li>Run the Spring Boot application: mvn spring-boot:run.</li>
  <li>Access the query interface at http://localhost:8080.</li>
</ul>

# Usage
<ul>
  <li>Use the provided API endpoints to log messages and search logs.</li>
  <li>Customize the log file paths and configurations in the application.properties file.</li>
  <li>Explore the codebase to understand the logging implementation and query interface.</li>
</ui>

# Sample Queries
Here are some sample queries you can execute:
<ul>
  <li>Search for all logs with the level set to "error".</li>
  <li>Search for logs with the message containing a specific term.</li>
  <li>Filter logs between specific timestamp ranges.</li>
</ul>
