package com.busapp.controller;

import com.busapp.dto.BusRouteRequest;
import com.busapp.dto.BusRouteResponse;
import com.busapp.service.BusRouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transport")
public class BusRouteController {
    @Autowired
    private BusRouteService busRouteService;
    
    @PostMapping("/route")
    public ResponseEntity<BusRouteResponse> createRoute(@Valid @RequestBody BusRouteRequest request) {
        BusRouteResponse response = busRouteService.createRoute(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/route/{id}")
    public ResponseEntity<BusRouteResponse> getRouteById(@PathVariable Long id) {
        BusRouteResponse response = busRouteService.getRouteById(id);
        return ResponseEntity.ok(response);
    }
}