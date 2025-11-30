package com.busapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * BusRequest - Data Transfer Object for creating a new bus
 * 
 * This class represents the JSON request body for POST /transport/bus
 * It includes validation annotations to ensure data integrity
 */
public class BusRequest {
    
    /**
     * Bus registration number
     * @NotBlank - Ensures the bus number is provided and not empty
     */
    @NotBlank(message = "Bus number cannot be blank")
    private String busNo;
    
    /**
     * Color of the bus
     * This field is optional (no validation annotation)
     */
    private String color;
    
    /**
     * Seating capacity of the bus
     * This field is optional
     */
    private Integer capacity;
    
    /**
     * ID of the route this bus belongs to
     * @NotNull - Ensures a route ID is provided
     * Every bus must be assigned to a route
     */
    @NotNull(message = "Route ID cannot be null")
    private Long routeId;
    
    // ==================== Constructors ====================
    
    public BusRequest() {
    }
    
    public BusRequest(String busNo, String color, Integer capacity, Long routeId) {
        this.busNo = busNo;
        this.color = color;
        this.capacity = capacity;
        this.routeId = routeId;
    }
    
    // ==================== Getters and Setters ====================
    
    public String getBusNo() {
        return busNo;
    }
    
    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Integer getCapacity() {
        return capacity;
    }
    
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    public Long getRouteId() {
        return routeId;
    }
    
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}