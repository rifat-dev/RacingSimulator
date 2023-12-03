package com.rifat.racingSimulator.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FlyingShipAirVehicle")
public class FlyingShipAirVehicle extends AirVehicle {

    public FlyingShipAirVehicle() {
    }

    public FlyingShipAirVehicle(double speed) {
        super(speed);
    }

    @Override
    double applyAccelerationCoefficient(double distance) {
        return Math.pow(distance, 0.5) / 5;
    }

    @Override
    public double calculateTrackTime(double distance) {
        double movementTimeOnly = distance / (this.getSpeed() * applyAccelerationCoefficient(distance));
        return movementTimeOnly;
    }
    
}
