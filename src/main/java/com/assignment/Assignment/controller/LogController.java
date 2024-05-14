package com.assignment.Assignment.controller;
import com.assignment.Assignment.service.LogService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Slf4j
@RestController
@CrossOrigin
public class LogController {
    private static final String LOG_FILES_DIRECTORY = "./src/main/resources/logs/"; // Change as needed

    @Autowired
    private LogService logService;

    // Search logs by level, logString, timestamp, and source
    @GetMapping("/logs/search")
    public String searchLogs(@RequestParam(required = false) String level,
                             @RequestParam(required = false) String logString,
                             @RequestParam(required = false) String timestamp,
                             @RequestParam(required = false) String source) {
        List<String> results = new ArrayList<>();
        try {
            List<String> logFiles = Files.list(Paths.get(LOG_FILES_DIRECTORY))
                    .filter(Files::isRegularFile)
                    .map(file -> file.toString())
                    .collect(Collectors.toList());

            for (String logFile : logFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if ((level == null || line.contains("\"level\": \"" + level + "\""))
                                && (logString == null || line.contains("\"log_string\": \"" + logString + "\""))
                                && (timestamp == null || line.contains("\"timestamp\": \"" + timestamp + "\""))
                                && (source == null || line.contains("\"metadata\": {\"source\": \"" + source + "\""))) {
                            results.add(line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results.toString();
    }

    // Check if a log entry matches the search criteria including date range
    private boolean matchesSearchCriteria(String logEntry, String level, String logString, String source) {
        if ((level != null && !logEntry.contains("\"level\": \"" + level + "\""))
                || (logString != null && !logEntry.contains("\"log_string\": \"" + logString + "\""))
                || (source != null && !logEntry.contains("\"metadata\": {\"source\": \"" + source + "\""))) {
            return false;
        }

        return true;
    }



    @GetMapping("/success")
    public String successLog(){
        try {
            logService.log("SUCCESS", "hello from success", "success.log");
            logService.log("INFO", "hello from success", "info.log");

        } catch (Exception e) {
            logService.log("ERROR","error in api 1", "error.log");
        }
        return "api 1 for success";
    }

    @GetMapping("/err")
    public String errorLog(){
        try {
            logService.log("ERROR", "hello from error", "error.log");
            logService.log("INFO", "hello from error", "info.log");

        } catch (Exception e) {
            logService.log("ERROR","error in api 2", "error.log");
        }
        return "api 2 for error";
    }
    @GetMapping("/")
    public String createLog(@RequestParam("level") String level,
                            @RequestParam("logString") String logString,
                            @RequestParam("source") String source) {
        try {
            System.out.println(source);
            logService.log(level, logString, source);
        } catch (Exception e) {
            logService.log("ERROR", "error", "error.log");
        }
        return "dynamic api for logging";
    }
}
