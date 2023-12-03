package com.rifat.racingSimulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rifat.racingSimulator.model.LandVehicle;

@Repository
public interface LandVehicleRepository extends JpaRepository<LandVehicle, Long> {

    @Query("SELECT av FROM LandVehicle av")
    List<LandVehicle> findAllLandVehicles();
}
