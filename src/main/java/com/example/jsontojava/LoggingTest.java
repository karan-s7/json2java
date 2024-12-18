package com.example.jsontojava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingTest {
    private static final Logger log = LogManager.getLogger(LoggingTest.class);

    public static void main(String[] args) {
        log.info("This is a test INFO log");
        log.error("This is a test ERROR log");
    }
}
