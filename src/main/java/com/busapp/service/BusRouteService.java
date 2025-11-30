package com.busapp.service;

import com.busapp.dto.BusRouteRequest;
import com.busapp.dto.BusRouteResponse;
import com.busapp.entity.BusRoute;
import com.busapp.exception.InvalidRouteIdException;
import com.busapp.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusRouteService {
    @Autowired
    private BusRouteRepository busRouteRepository;
    
    @Transactional
    public BusRouteResponse createRoute(BusRouteRequest request) {
        BusRoute busRoute = new BusRoute(request.getTitle(), request.getSource(), request.getDestination(), request.getStations());
        BusRoute savedRoute = busRouteRepository.save(busRoute);
        return new BusRouteResponse(savedRoute.getId(), savedRoute.getTitle(), savedRoute.getSource(), savedRoute.getDestination(), savedRoute.getStations());
    }
    
    public BusRouteResponse getRouteById(Long id) {
        BusRoute busRoute = busRouteRepository.findById(id).orElseThrow(() -> new InvalidRouteIdException(id));
        return new BusRouteResponse(busRoute);
    }
}