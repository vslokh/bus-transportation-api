package com.busapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BusRoute Entity - Represents a bus route in the transportation system
 * 
 * This class maps to the "bus_routes" table in the database
 * It has a One-to-Many relationship with Bus entity (one route can have multiple buses)
 */
@Entity  // Marks this class as a JPA entity (database table)
@Table(name = "bus_routes")  // Specifies the table name in the database
public class BusRoute {
    
    /**
     * Primary Key - Unique identifier for each bus route
     * 
     * @Id - Marks this field as the primary key
     * @GeneratedValue - Tells JPA to auto-generate the value
     * GenerationType.IDENTITY - Uses database auto-increment feature
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Title of the bus route (e.g., "PUNE_TO_MUMBAI_BUS")
     * 
     * @Column(nullable = false) - This field cannot be null in the database
     * This is a required field
     */
    @Column(nullable = false)
    private String title;
    
    /**
     * Source city/location where the bus route starts
     * 
     * nullable = false means this is a mandatory field
     */
    @Column(nullable = false)
    private String source;
    
    /**
     * Destination city/location where the bus route ends
     * 
     * nullable = false means this is a mandatory field
     */
    @Column(nullable = false)
    private String destination;
    
    /**
     * Comma-separated list of stations along the route
     * 
     * @Column(length = 1000) - Allows up to 1000 characters
     * This field is optional (can be null)
     */
    @Column(length = 1000)
    private String stations;
    
    /**
     * List of buses associated with this route
     * 
     * @OneToMany - Defines a one-to-many relationship
     *   - One BusRoute can have Many Buses
     *   - mappedBy = "route" - Refers to the "route" field in Bus entity
     * 
     * cascade = CascadeType.ALL - Any operation (save, delete) on BusRoute 
     *                             will cascade to associated buses
     * 
     * orphanRemoval = true - If a bus is removed from this list, 
     *                        it will be deleted from the database
     * 
     * @JsonManagedReference - Prevents infinite recursion during JSON serialization
     *                         This is the "forward" part of the relationship
     */
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Bus> buses = new ArrayList<>();
    
    // ==================== Constructors ====================
    
    /**
     * Default no-argument constructor
     * Required by JPA for creating entity instances
     */
    public BusRoute() {
    }
    
    /**
     * Parameterized constructor for creating BusRoute with initial values
     * 
     * @param title - Route title
     * @param source - Starting location
     * @param destination - Ending location
     * @param stations - Intermediate stations
     */
    public BusRoute(String title, String source, String destination, String stations) {
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.stations = stations;
    }
    
    // ==================== Getters and Setters ====================
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public List<Bus> getBuses() {
        return buses;
    }
    
    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}