package com.busapp.dto;

import com.busapp.entity.Bus;

/**
 * BusResponse - Data Transfer Object for returning bus data
 * 
 * This class represents the JSON response body for:
 * - POST /transport/bus
 * - GET /transport/bus/search/{routeId}
 * - Part of GET /transport/route/{id} response
 */
public class BusResponse {
    
    private Long id;
    private String busNo;
    private String color;
    private Integer capacity;
    private Long routeId;
    
    public BusResponse() {
    }
    
    /**
     * Constructor that converts Bus entity to BusResponse DTO
     * @param bus - The Bus entity from database
     */
    public BusResponse(Bus bus) {
        this.id = bus.getId();
        this.busNo = bus.getBusNo();
        this.color = bus.getColor();
        this.capacity = bus.getCapacity();
        this.routeId = bus.getRouteId();
    }
    
    public BusResponse(Long id, String busNo, String color, Integer capacity, Long routeId) {
        this.id = id;
        this.busNo = busNo;
        this.color = color;
        this.capacity = capacity;
        this.routeId = routeId;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBusNo() { return busNo; }
    public void setBusNo(String busNo) { this.busNo = busNo; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Long getRouteId() { return routeId; }
    public void setRouteId(Long routeId) { this.routeId = routeId; }
}