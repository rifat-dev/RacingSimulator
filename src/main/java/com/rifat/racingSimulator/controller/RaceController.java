package com.rifat.racingSimulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rifat.racingSimulator.DTO.RaceResultDTO;
import com.rifat.racingSimulator.DTO.RaceStartDTO;
import com.rifat.racingSimulator.service.RaceService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/races")
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping("/start")
    public ResponseEntity<List<RaceResultDTO>> startRace(@Valid @RequestBody RaceStartDTO request) {

        List<RaceResultDTO> raceResults = raceService.startRace(request.getVehicles(), request.getDistance(), request.getRaceType());
        return ResponseEntity.ok(raceResults);
    }
    
}
