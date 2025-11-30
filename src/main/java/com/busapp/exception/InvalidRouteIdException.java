package com.busapp.exception;

/**
 * InvalidRouteIdException - Custom exception for invalid route operations
 * 
 * This exception is thrown when:
 * - A route ID is not found in the database
 * - An operation is attempted on a non-existent route
 * 
 * Extending RuntimeException means:
 * - This is an unchecked exception (no need for throws declaration)
 * - Spring will automatically handle it via @ControllerAdvice
 */
public class InvalidRouteIdException extends RuntimeException {
    
    /**
     * Constructor with custom error message
     * @param message - The error message to display
     */
    public InvalidRouteIdException(String message) {
        super(message);
    }
    
    /**
     * Constructor that creates a standard error message
     * @param routeId - The route ID that was not found
     */
    public InvalidRouteIdException(Long routeId) {
        super("Route with ID " + routeId + " not found");
    }
}