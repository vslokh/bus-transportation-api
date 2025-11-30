package com.busapp.repository;

import com.busapp.entity.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BusRouteRepository - Data Access Layer for BusRoute entity
 * 
 * This interface extends JpaRepository which provides:
 * - All basic CRUD operations (Create, Read, Update, Delete)
 * - Pagination and sorting capabilities
 * - Query methods
 * 
 * We don't need to write any implementation code!
 * Spring Data JPA automatically creates the implementation at runtime
 * 
 * JpaRepository<BusRoute, Long> means:
 * - BusRoute: The entity type this repository manages
 * - Long: The type of the primary key (id field in BusRoute)
 */
@Repository  // Marks this as a Spring Data repository component
public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
    
    /**
     * Inherited methods from JpaRepository that we can use:
     * 
     * - save(BusRoute entity) - Saves or updates a bus route
     * - findById(Long id) - Finds a route by its ID, returns Optional<BusRoute>
     * - findAll() - Returns all bus routes
     * - deleteById(Long id) - Deletes a route by ID
     * - existsById(Long id) - Checks if a route exists with given ID
     * - count() - Returns total number of routes
     * 
     * We can also add custom query methods here if needed
     * Spring Data JPA will automatically implement them based on method names
     * 
     * Example custom methods (not needed for this project):
     * - List<BusRoute> findBySource(String source);
     * - List<BusRoute> findBySourceAndDestination(String source, String destination);
     */
}