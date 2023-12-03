package com.rifat.racingSimulator.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MagicCarpetAirVehicle")
public class MagicCarpetAirVehicle extends AirVehicle{


    public MagicCarpetAirVehicle() {
    }

    public MagicCarpetAirVehicle(double speed) {
        super(speed);
    }

    @Override
    double applyAccelerationCoefficient(double distance) {
        return (Math.pow(distance, 0.1) / 2) * Math.abs(distance / (distance - 100));
    }

    @Override
    public double calculateTrackTime(double distance) {
        double movementTimeOnly = distance / (this.getSpeed() * applyAccelerationCoefficient(distance));
        return movementTimeOnly;
    }
    
}
