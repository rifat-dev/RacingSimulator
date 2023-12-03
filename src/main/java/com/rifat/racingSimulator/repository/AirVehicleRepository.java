package com.rifat.racingSimulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rifat.racingSimulator.model.AirVehicle;

public interface AirVehicleRepository extends JpaRepository<AirVehicle, Long> {
    
    @Query("SELECT av FROM AirVehicle av")
    List<AirVehicle> findAllAirVehicles();
}
