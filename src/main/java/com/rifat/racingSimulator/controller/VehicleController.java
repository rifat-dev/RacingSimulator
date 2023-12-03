package com.rifat.racingSimulator.controller;

import com.rifat.racingSimulator.model.AirVehicle;
import com.rifat.racingSimulator.model.LandVehicle;
import com.rifat.racingSimulator.model.Vehicle;
import com.rifat.racingSimulator.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/type")
    public ResponseEntity<List<?>> getVehiclesByType(@RequestParam(name = "type", required = false) String type) {
        List<?> vehicles;

        if (type == null) {
            return ResponseEntity.badRequest().build();
        }

        switch (type.toUpperCase()) {
            case "LAND_ONLY":
                vehicles = vehicleService.getLandVehicles();
                break;
            case "AIR_ONLY":
                vehicles = vehicleService.getAirVehicles();
                break;
            case "ALL_TYPES":
                vehicles = vehicleService.getAllVehicles();
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/land")
    public Vehicle saveLandVehicle(@RequestBody LandVehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @PostMapping("/air")
    public Vehicle saveAirVehicle(@RequestBody AirVehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

}