package com.rifat.racingSimulator.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RaceResultDTO {

    @NotNull(message = "Cannot be null")
    private Long vehicleId;

    @Positive(message = "Speed must be a positive number")
    private double currentResultTime;

    @NotBlank(message = "Vehicle type cannot be blank")
    private String vehicleType;

    @Positive(message = "Distance must be a positive number")
    private double distance;

    public RaceResultDTO() {
    }

    public RaceResultDTO(Long vehicleId, double currentResultTime, String vehicleType, double distance) {
        this.vehicleId = vehicleId;
        this.currentResultTime = currentResultTime;
        this.vehicleType = vehicleType;
        this.distance = distance;
    }

    public Long getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getCurrentResultTime() {
        return this.currentResultTime;
    }

    public void setCurrentResultTime(double currentResultTime) {
        this.currentResultTime = currentResultTime;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RaceResultDTO{" +
                "vehicleId=" + vehicleId +
                ", currentResultTime=" + currentResultTime +
                ", vehicleType='" + vehicleType + '\'' +
                ", distance=" + distance +
                '}';
    }

}
