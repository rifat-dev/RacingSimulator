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
    @JsonSubTypes.Type(value = BroomAirVehicle.class, name = "BroomAirVehicle"),
    @JsonSubTypes.Type(value = FlyingShipAirVehicle.class, name = "FlyingShipAirVehicle"),
    @JsonSubTypes.Type(value = StupaOfBabaYagaAirVehicle.class, name = "StupaOfBabaYagaAirVehicle"),
    @JsonSubTypes.Type(value = MagicCarpetAirVehicle.class, name = "MagicCarpetAirVehicle")
})
public abstract class AirVehicle extends Vehicle {

    public AirVehicle() {
    }

    public AirVehicle(double speed) {
        super(speed);
    }

    abstract double applyAccelerationCoefficient(double distance);

}
