package com.rifat.racingSimulator.model;

import java.util.function.DoubleUnaryOperator;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CentaurLandVehicle")
public class CentaurLandVehicle extends LandVehicle {


    public CentaurLandVehicle() {
    }

    public CentaurLandVehicle(double speed, double moveTimeBeforeRest) {
        super(speed, moveTimeBeforeRest);
    }

    @Override
    double totalRestTime(int stopSequence) {
        double curTotalRestTime = 0.0;
        DoubleUnaryOperator func = x -> Math.exp(x * 2) / 10;
        for (int stopNumber = 1; stopNumber <= stopSequence; stopNumber++) {
            curTotalRestTime += func.applyAsDouble(stopNumber);
        }
        return curTotalRestTime;
    }

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
