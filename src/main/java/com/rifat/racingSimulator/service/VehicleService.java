package com.rifat.racingSimulator.service;

import com.rifat.racingSimulator.model.AirVehicle;
import com.rifat.racingSimulator.model.LandVehicle;
import com.rifat.racingSimulator.model.Vehicle;
import com.rifat.racingSimulator.repository.AirVehicleRepository;
import com.rifat.racingSimulator.repository.LandVehicleRepository;
import com.rifat.racingSimulator.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final LandVehicleRepository landVehicleRepository;
    private final AirVehicleRepository airVehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, LandVehicleRepository landVehicleRepository, AirVehicleRepository airVehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.landVehicleRepository = landVehicleRepository;
        this.airVehicleRepository = airVehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<LandVehicle> getLandVehicleById(Long id) {
        return landVehicleRepository.findById(id);
    }

    public Optional<AirVehicle> getAirVehicleById(Long id) {
        return airVehicleRepository.findById(id);
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<LandVehicle> getLandVehicles() {
        return landVehicleRepository.findAllLandVehicles();
    }

    public List<AirVehicle> getAirVehicles() {
        return airVehicleRepository.findAllAirVehicles();
    }

}
