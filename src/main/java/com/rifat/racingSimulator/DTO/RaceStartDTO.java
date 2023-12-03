package com.rifat.racingSimulator.DTO;

import java.util.List;

import com.rifat.racingSimulator.model.RaceType;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RaceStartDTO {
    
    @Valid
    @NotEmpty(message = "Vehicles list cannot be empty")
    private List<Long> vehicles;

    @NotNull(message = "Distance cannot be null")
    @Positive(message = "Distance must be a positive number")
    private Double distance;

    @NotNull(message = "Race type cannot be null")
    private RaceType raceType;

    public RaceStartDTO() {
    }

    public RaceStartDTO(List<Long> vehicles, Double distance, RaceType raceType) {
        this.vehicles = vehicles;
        this.distance = distance;
        this.raceType = raceType;
    }

    public List<Long> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(List<Long> vehicles) {
        this.vehicles = vehicles;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public RaceType getRaceType() {
        return this.raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

}
