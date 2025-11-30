package com.busapp.controller;

import com.busapp.dto.BusRequest;
import com.busapp.dto.BusResponse;
import com.busapp.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transport")
public class BusController {
    @Autowired
    private BusService busService;
    
    @PostMapping("/bus")
    public ResponseEntity<BusResponse> createBus(@Valid @RequestBody BusRequest request) {
        BusResponse response = busService.createBus(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/bus/search/{routeId}")
    public ResponseEntity<List<BusResponse>> getBusesByRouteId(@PathVariable Long routeId) {
        List<BusResponse> buses = busService.getBusesByRouteId(routeId);
        return ResponseEntity.ok(buses);
    }
}