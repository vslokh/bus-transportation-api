package com.busapp.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * BusRouteRequest - Data Transfer Object for creating a new bus route
 * 
 * DTO (Data Transfer Object) is used to:
 * - Transfer data between client and server
 * - Separate API contract from database entities
 * - Apply validation rules on incoming data
 * 
 * This class represents the JSON request body for POST /transport/route
 */
public class BusRouteRequest {
    
    /**
     * Title of the bus route
     * 
     * @NotBlank - Jakarta Bean Validation annotation
     *   - Checks that the string is not null
     *   - Checks that the string is not empty ("")
     *   - Checks that the string is not only whitespace ("   ")
     *   - If validation fails, returns 400 Bad Request with the message
     */
    @NotBlank(message = "Title cannot be blank")
    private String title;
    
    /**
     * Source location of the route
     * @NotBlank ensures this field is required and not empty
     */
    @NotBlank(message = "Source cannot be blank")
    private String source;
    
    /**
     * Destination location of the route
     * @NotBlank ensures this field is required and not empty
     */
    @NotBlank(message = "Destination cannot be blank")
    private String destination;
    
    /**
     * Comma-separated list of stations
     * This field is optional (no @NotBlank annotation)
     * Can be null or empty
     */
    private String stations;
    
    // ==================== Constructors ====================
    
    /**
     * Default constructor
     * Required for Jackson (JSON library) to deserialize JSON into this object
     */
    public BusRouteRequest() {
    }
    
    /**
     * Parameterized constructor
     * Useful for creating request objects in tests
     */
    public BusRouteRequest(String title, String source, String destination, String stations) {
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.stations = stations;
    }
    
    // ==================== Getters and Setters ====================
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getStations() {
        return stations;
    }
    
    public void setStations(String stations) {
        this.stations = stations;
    }
}