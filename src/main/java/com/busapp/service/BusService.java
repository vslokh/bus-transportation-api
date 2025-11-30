package com.busapp.service;

import com.busapp.dto.BusRequest;
import com.busapp.dto.BusResponse;
import com.busapp.entity.Bus;
import com.busapp.entity.BusRoute;
import com.busapp.exception.InvalidRouteIdException;
import com.busapp.repository.BusRepository;
import com.busapp.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusRouteRepository busRouteRepository;

    @Transactional
    public BusResponse createBus(BusRequest request) {
        BusRoute busRoute = busRouteRepository.findById(request.getRouteId()).orElseThrow(() -> new InvalidRouteIdException(request.getRouteId()));
        Bus bus = new Bus(request.getBusNo(), request.getColor(), request.getCapacity(), request.getRouteId());
        Bus savedBus = busRepository.save(bus);
        return new BusResponse(savedBus.getId(), savedBus.getBusNo(), savedBus.getColor(), savedBus.getCapacity(), savedBus.getRouteId());
    }

    public List<BusResponse> getBusesByRouteId(Long routeId) {
        if (!busRouteRepository.existsById(routeId)) {
            throw new InvalidRouteIdException(routeId);
        }
        List<Bus> buses = busRepository.findByRouteId(routeId);
        return buses.stream().map(bus -> new BusResponse(bus)).collect(Collectors.toList());
    }
}