package com.rifat.racingSimulator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rifat.racingSimulator.model.AirVehicle;
import com.rifat.racingSimulator.model.LandVehicle;
import com.rifat.racingSimulator.model.Vehicle;
import com.rifat.racingSimulator.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleControllerView {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleControllerView(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String getAllVehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<AirVehicle> airVehicles = new ArrayList<>();
        List<LandVehicle> landVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof AirVehicle) {
                airVehicles.add((AirVehicle) vehicle);
            } else if (vehicle instanceof LandVehicle) {
                landVehicles.add((LandVehicle) vehicle);
            }
        }

        model.addAttribute("landVehicles", landVehicles);
        model.addAttribute("airVehicles", airVehicles);

        return "vehicles";
    }
}
