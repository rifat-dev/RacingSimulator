package com.rifat.racingSimulator.model;

import java.io.Serializable;
import java.util.Objects;

public class RaceParticipantLinkId implements Serializable {

    private Long race;

    private Long vehicle;

    public Long getRace() {
        return this.race;
    }

    public void setRace(Long race) {
        this.race = race;
    }

    public Long getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceParticipantLinkId that = (RaceParticipantLinkId) o;

        if (!Objects.equals(race, that.race)) return false;
        return Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        int result = race != null ? race.hashCode() : 0;
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        return result;
    }
}
