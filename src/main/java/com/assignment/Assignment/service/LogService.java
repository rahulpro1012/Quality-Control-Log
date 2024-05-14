package com.assignment.Assignment.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    private static final String LOG_FILE_PATH_PREFIX = "./src/main/resources/";

    // Method to log messages
    public void log(String level, String logString, String source) {
        String logMessage = String.format("{\"level\": \"%s\", \"log_string\": \"%s\", \"timestamp\": \"%s\", \"metadata\": {\"source\": \"%s\"}}",
                level, logString, Instant.now(), source);
        writeToFile(logMessage, getLogFilePath(level));
    }

    // Get log file path based on log level
    private String getLogFilePath(String level) {

        switch (level.toLowerCase()) {
            case "error":
                return LOG_FILE_PATH_PREFIX + "logs/error.log";
            case "success":
                return LOG_FILE_PATH_PREFIX + "logs/success.log";
            case "info":
                return LOG_FILE_PATH_PREFIX + "logs/info.log";
            default:
                return LOG_FILE_PATH_PREFIX + "logs/default.log";
        }
    }

    // Write log message to file
    private void writeToFile(String message, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(message);
        } catch (IOException e) {
            logger.error("Error writing log to file: {}", e.getMessage());
        }
    }
}
