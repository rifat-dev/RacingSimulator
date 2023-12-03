package com.rifat.racingSimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rifat.racingSimulator.model.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {
    
}
