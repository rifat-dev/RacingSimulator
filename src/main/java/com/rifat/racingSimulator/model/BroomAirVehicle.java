package com.rifat.racingSimulator.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BroomAirVehicle")
public class BroomAirVehicle extends AirVehicle {


    public BroomAirVehicle() {
    }

    public BroomAirVehicle(double speed) {
        super(speed);
    }

    @Override
    double applyAccelerationCoefficient(double distance) {
        return (distance + 5) / distance;
    }

    @Override
    public double calculateTrackTime(double distance) {
        double movementTimeOnly = distance / (this.getSpeed() * applyAccelerationCoefficient(distance));
        return movementTimeOnly;
    }

}
