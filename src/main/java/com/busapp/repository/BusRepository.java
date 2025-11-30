package com.busapp.repository;

import com.busapp.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * BusRepository - Data Access Layer for Bus entity
 * 
 * This interface extends JpaRepository which provides all basic CRUD operations
 * Spring Data JPA automatically creates the implementation at runtime
 * 
 * JpaRepository<Bus, Long> means:
 * - Bus: The entity type this repository manages
 * - Long: The type of the primary key (id field in Bus)
 */
@Repository  // Marks this as a Spring Data repository component
public interface BusRepository extends JpaRepository<Bus, Long> {
    
    /**
     * Custom query method to find all buses for a specific route
     * 
     * Spring Data JPA automatically implements this method based on the method name:
     * - "findBy" - tells Spring this is a query method
     * - "RouteId" - the field name in Bus entity (routeId)
     * - Spring generates: SELECT * FROM buses WHERE route_id = ?
     * 
     * @param routeId - The ID of the route to search for
     * @return List<Bus> - List of all buses on that route (empty list if none found)
     * 
     * Method naming conventions:
     * - findByFieldName - equals
     * - findByFieldNameContaining - LIKE %value%
     * - findByFieldNameGreaterThan - >
     * - findByFieldNameLessThan - <
     * - findByField1AndField2 - Multiple conditions with AND
     * - findByField1OrField2 - Multiple conditions with OR
     */
    List<Bus> findByRouteId(Long routeId);
    
    /**
     * Inherited methods from JpaRepository:
     * - save(Bus entity) - Saves or updates a bus
     * - findById(Long id) - Finds a bus by ID
     * - findAll() - Returns all buses
     * - deleteById(Long id) - Deletes a bus by ID
     * - existsById(Long id) - Checks if a bus exists
     */
}