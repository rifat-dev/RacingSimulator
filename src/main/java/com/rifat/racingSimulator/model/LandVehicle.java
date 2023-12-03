package com.rifat.racingSimulator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "vehicle_type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BootsOfSpeedLandVehicle.class, name = "BootsOfSpeedLandVehicle"),
    @JsonSubTypes.Type(value = CentaurLandVehicle.class, name = "CentaurLandVehicle"),
    @JsonSubTypes.Type(value = ChickenLeggedHutLandVehicle.class, name = "ChickenLeggedHutLandVehicle"),
    @JsonSubTypes.Type(value = PumpkinCarriageLandVehicle.class, name = "PumpkinCarriageLandVehicle")
})
public abstract class LandVehicle extends Vehicle {
    private double moveTimeBeforeRest;

    public LandVehicle() {
    }

    public LandVehicle(double speed, double moveTimeBeforeRest) {
        super(speed);
        this.moveTimeBeforeRest = moveTimeBeforeRest;
    }

    public double getMoveTimeBeforeRest() {
        return this.moveTimeBeforeRest;
    }

    public void setMoveTimeBeforeRest(double moveTimeBeforeRest) {
        this.moveTimeBeforeRest = moveTimeBeforeRest;
    }

    abstract double totalRestTime(int stopSequence);
    
}
