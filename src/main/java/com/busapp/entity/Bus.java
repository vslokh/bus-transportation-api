package com.busapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Bus Entity - Represents a bus in the transportation system
 * 
 * This class maps to the "buses" table in the database
 * It has a Many-to-One relationship with BusRoute entity (many buses can belong to one route)
 */
@Entity  // Marks this class as a JPA entity (database table)
@Table(name = "buses")  // Specifies the table name in the database
public class Bus {
    
    /**
     * Primary Key - Unique identifier for each bus
     * 
     * @Id - Marks this field as the primary key
     * @GeneratedValue - Tells JPA to auto-generate the value
     * GenerationType.IDENTITY - Uses database auto-increment feature
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Bus number/registration number (e.g., "MH12 AU-3456")
     * 
     * @Column(nullable = false) - This field cannot be null in the database
     * This is a required field
     */
    @Column(nullable = false)
    private String busNo;
    
    /**
     * Color of the bus (e.g., "Green", "Red")
     * This field is optional (can be null)
     */
    private String color;
    
    /**
     * Seating capacity of the bus (number of seats)
     * This field is optional (can be null)
     */
    private Integer capacity;
    
    /**
     * Reference to the BusRoute this bus belongs to
     * 
     * @ManyToOne - Defines a many-to-one relationship
     *   - Many Buses can belong to One BusRoute
     * 
     * fetch = FetchType.LAZY - The route data is loaded only when accessed
     *                          (not loaded immediately with the bus)
     *                          This improves performance
     * 
     * @JoinColumn - Specifies the foreign key column in the buses table
     *   - name = "route_id" - The column name in the database
     *   - nullable = false - Every bus must belong to a route
     * 
     * @JsonBackReference - Prevents infinite recursion during JSON serialization
     *                      This is the "back" part of the relationship
     *                      (opposite of @JsonManagedReference in BusRoute)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    @JsonBackReference
    private BusRoute route;
    
    /**
     * Route ID - Read-only field to store the route ID
     * 
     * @Column with insertable and updatable set to false means:
     *   - This field is not used when inserting new records
     *   - This field is not used when updating existing records
     *   - It's purely for reading the route_id value
     *   - The actual route_id is managed by the @JoinColumn above
     * 
     * This is useful for returning routeId in JSON responses without
     * loading the entire BusRoute object
     */
    @Column(name = "route_id", insertable = false, updatable = false)
    private Long routeId;
    
    // ==================== Constructors ====================
    
    /**
     * Default no-argument constructor
     * Required by JPA for creating entity instances
     */
    public Bus() {
    }
    
    /**
     * Parameterized constructor for creating Bus with initial values
     * 
     * @param busNo - Bus registration number
     * @param color - Bus color
     * @param capacity - Seating capacity
     * @param route - The BusRoute this bus belongs to
     */
    public Bus(String busNo, String color, Integer capacity, BusRoute route) {
        this.busNo = busNo;
        this.color = color;
        this.capacity = capacity;
        this.route = route;
        // Set the routeId from the route object if it exists
        this.routeId = route != null ? route.getId() : null;
    }
    
    // ==================== Getters and Setters ====================
    
    /**
     * Gets the unique ID of this bus
     * @return Long - The bus ID
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the ID of this bus
     * Usually handled automatically by JPA
     * @param id - The bus ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the bus registration number
     * @return String - The bus number
     */
    public String getBusNo() {
        return busNo;
    }
    
    /**
     * Sets the bus registration number
     * @param busNo - The bus number to set
     */
    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }
    
    /**
     * Gets the color of the bus
     * @return String - The bus color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Sets the color of the bus
     * @param color - The bus color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Gets the seating capacity of the bus
     * @return Integer - The number of seats
     */
    public Integer getCapacity() {
        return capacity;
    }
    
    /**
     * Sets the seating capacity of the bus
     * @param capacity - The number of seats to set
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Gets the BusRoute this bus belongs to
     * @return BusRoute - The associated route
     */
    public BusRoute getRoute() {
        return route;
    }
    
    /**
     * Sets the BusRoute this bus belongs to
     * Also updates the routeId field
     * @param route - The route to associate with this bus
     */
    public void setRoute(BusRoute route) {
        this.route = route;
        // Update routeId whenever route is set
        this.routeId = route != null ? route.getId() : null;
    }
    
    /**
     * Gets the ID of the route this bus belongs to
     * @return Long - The route ID
     */
    public Long getRouteId() {
        return routeId;
    }
    
    /**
     * Sets the route ID
     * Note: This is primarily for internal use
     * Use setRoute() to properly associate a bus with a route
     * @param routeId - The route ID to set
     */
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}