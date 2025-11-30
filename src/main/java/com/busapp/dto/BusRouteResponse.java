package com.busapp.dto;

import com.busapp.entity.BusRoute;
import java.util.List;
import java.util.stream.Collectors;

public class BusRouteResponse {
    private Long id;
    private String title;
    private String source;
    private String destination;
    private String stations;
    private List<BusResponse> buses;
    
    public BusRouteResponse() {}
    
    public BusRouteResponse(BusRoute busRoute) {
        this.id = busRoute.getId();
        this.title = busRoute.getTitle();
        this.source = busRoute.getSource();
        this.destination = busRoute.getDestination();
        this.stations = busRoute.getStations();
        this.buses = busRoute.getBuses().stream().map(BusResponse::new).collect(Collectors.toList());
    }
    
    public BusRouteResponse(Long id, String title, String source, String destination, String stations) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.stations = stations;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getStations() { return stations; }
    public void setStations(String stations) { this.stations = stations; }
    public List<BusResponse> getBuses() { return buses; }
    public void setBuses(List<BusResponse> buses) { this.buses = buses; }
}