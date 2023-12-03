package com.rifat.racingSimulator.model;

import java.util.function.DoubleUnaryOperator;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BootsOfSpeedLandVehicle")
public class BootsOfSpeedLandVehicle extends LandVehicle {


    public BootsOfSpeedLandVehicle() {
    }
    
    /**
     * Constructs a new BootsOfSpeedLandVehicle with the specified characteristics.
     *
     * @param speed              The speed of the land vehicle in units per hour
     * @param moveTimeBeforeRest The maximum time the vehicle can move before requiring rest in hours.
     */
    public BootsOfSpeedLandVehicle(double speed, double moveTimeBeforeRest) {
        super(speed, moveTimeBeforeRest);
    }

    /**
     * Calculates the total rest time based on the stop sequence using a mathematical function.
     *
     * @param stopSequence The sequence of stops made by the land vehicle.
     * @return The total rest time in hours.
     */
    @Override
    double totalRestTime(int stopSequence) {
        double curTotalRestTime = 0.0;
        DoubleUnaryOperator func = x -> 2 * x - 1;
        for (int stopNumber = 1; stopNumber <= stopSequence; stopNumber++) {
            curTotalRestTime += func.applyAsDouble(stopNumber);
        }
        return curTotalRestTime;
    }

    /**
     * Calculates the total time required to traverse a given distance,
     * considering rest breaks based on the specified move time before rest.
     *
     * @param distance The distance to be traveled in units.
     * @return The total time required for the journey in hours.
     */
    @Override
    public double calculateTrackTime(double distance) {
        double movementTimeOnly = distance / this.getSpeed();
        int cntRests = (int)(movementTimeOnly / this.getMoveTimeBeforeRest());
        int numberOfRests = ((int)(movementTimeOnly % this.getMoveTimeBeforeRest()) == 0) ? cntRests - 1 : cntRests;
        if (numberOfRests == 0) {
            return movementTimeOnly;
        }
        return movementTimeOnly + totalRestTime(numberOfRests);
    }
    
}
