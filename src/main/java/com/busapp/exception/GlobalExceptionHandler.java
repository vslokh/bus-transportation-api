package com.busapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler - Centralized exception handling for the entire application
 * 
 * @ControllerAdvice - This annotation makes this class a global exception handler
 *                     It intercepts exceptions thrown by any @Controller or @RestController
 *                     
 * Benefits:
 * - Centralized error handling logic
 * - Consistent error response format across the application
 * - Separates error handling from business logic
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * Handles InvalidRouteIdException
     * 
     * @ExceptionHandler - Tells Spring to invoke this method when InvalidRouteIdException is thrown
     * 
     * @param ex - The exception that was thrown
     * @return ResponseEntity with error details and HTTP 404 NOT FOUND status
     * 
     * Response format:
     * {
     *   "timestamp": "2025-11-30T19:30:00",
     *   "status": 404,
     *   "error": "Not Found",
     *   "message": "Route with ID 123 not found"
     * }
     */
    @ExceptionHandler(InvalidRouteIdException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidRouteId(InvalidRouteIdException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());  // 404
        errorResponse.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());  // "Not Found"
        errorResponse.put("message", ex.getMessage());
        
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    /**
     * Handles validation errors from @Valid annotation
     * 
     * When a @Valid request body fails validation (e.g., @NotBlank, @NotNull),
     * Spring throws MethodArgumentNotValidException
     * 
     * This method extracts all validation errors and returns them in a user-friendly format
     * 
     * @param ex - The validation exception containing all field errors
     * @return ResponseEntity with validation error details and HTTP 400 BAD REQUEST status
     * 
     * Response format:
     * {
     *   "timestamp": "2025-11-30T19:30:00",
     *   "status": 400,
     *   "error": "Validation Failed",
     *   "errors": {
     *     "title": "Title cannot be blank",
     *     "source": "Source cannot be blank"
     *   }
     * }
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
        
        // Extract all field validation errors
        // getBindingResult() returns the validation result
        // getAllErrors() returns list of all validation errors
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();  // Field that failed validation
            String errorMessage = error.getDefaultMessage();     // Validation error message
            errors.put(fieldName, errorMessage);
        });
        
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());  // 400
        errorResponse.put("error", "Validation Failed");
        errorResponse.put("errors", errors);
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Handles all other unexpected exceptions
     * 
     * This is a catch-all handler for any exception not handled by other @ExceptionHandler methods
     * 
     * @param ex - Any exception that wasn't caught by other handlers
     * @return ResponseEntity with error details and HTTP 500 INTERNAL SERVER ERROR status
     * 
     * Response format:
     * {
     *   "timestamp": "2025-11-30T19:30:00",
     *   "status": 500,
     *   "error": "Internal Server Error",
     *   "message": "An unexpected error occurred"
     * }
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());  // 500
        errorResponse.put("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse.put("message", "An unexpected error occurred: " + ex.getMessage());
        
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}