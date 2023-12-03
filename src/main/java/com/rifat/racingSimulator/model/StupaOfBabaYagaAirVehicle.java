package com.rifat.racingSimulator.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("StupaOfBabaYagaAirVehicle")
public class StupaOfBabaYagaAirVehicle extends AirVehicle {


    public StupaOfBabaYagaAirVehicle() {
    }

    public StupaOfBabaYagaAirVehicle(double speed) {
        super(speed);
    }

    @Override
    double applyAccelerationCoefficient(double distance) {
        return Math.pow(100 / Math.pow(distance, 2), 0.3) + 1;
    }

    @Override
    public double calculateTrackTime(double distance) {
        double movementTimeOnly = distance / (this.getSpeed() * applyAccelerationCoefficient(distance));
        return movementTimeOnly;
    }
    
}
