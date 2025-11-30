package com.busapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application Class for Bus Transportation REST API
 * 
 * @SpringBootApplication is a convenience annotation that combines:
 * - @Configuration: Tags the class as a source of bean definitions
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings
 * - @ComponentScan: Tells Spring to look for components, configurations, and services in the com.busapp package
 */
@SpringBootApplication
public class BusTransportationApplication {
    
    /**
     * Main method - Entry point of the Spring Boot application
     * 
     * @param args Command line arguments passed to the application
     * 
     * SpringApplication.run() does the following:
     * 1. Creates an ApplicationContext (Spring container)
     * 2. Registers command line arguments as Spring beans
     * 3. Starts the embedded Tomcat server on port 8080 (default)
     * 4. Scans for components and auto-configures the application
     */
    public static void main(String[] args) {
        SpringApplication.run(BusTransportationApplication.class, args);
    }
}