package com.rifat.racingSimulator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifat.racingSimulator.DTO.RaceResultDTO;
import com.rifat.racingSimulator.model.Race;
import com.rifat.racingSimulator.model.RaceParticipantLink;
import com.rifat.racingSimulator.model.RaceType;
import com.rifat.racingSimulator.model.Vehicle;
import com.rifat.racingSimulator.repository.RaceParticipantLinkRepository;
import com.rifat.racingSimulator.repository.RaceRepository;

import jakarta.transaction.Transactional;

@Service
public class RaceService {
    private final RaceRepository raceRepository;
    private final RaceParticipantLinkRepository participantLinkRepository;
    private final VehicleService vehicleService;

    @Autowired
    public RaceService(RaceRepository raceRepository, RaceParticipantLinkRepository participantLinkRepository, VehicleService vehicleService) {
        this.raceRepository = raceRepository;
        this.participantLinkRepository = participantLinkRepository;
        this.vehicleService = vehicleService;
    }

    @Transactional
    public List<RaceResultDTO> startRace(List<Long> vehiclesId, double distance, RaceType raceType) {
        Race currentRace = raceRepository.save(new Race(raceType, distance));
        List<RaceResultDTO> finalResult = new ArrayList<>();

        for (Long id : vehiclesId) {
            Optional<Vehicle> vehOptional = vehicleService.getVehicleById(id);
            if (vehOptional.isPresent()) {
                Vehicle veh = vehOptional.get();
                if (currentRace != null) {
                    RaceParticipantLink participantLink = new RaceParticipantLink();
                    participantLink.setRace(currentRace);
                    participantLink.setVehicle(veh);
                    double resultTrackTime = veh.calculateTrackTime(distance);
                    participantLink.setResultTrackTime(resultTrackTime);
                    // participantLinkRepository.save(participantLink);
        
                    finalResult.add(new RaceResultDTO(veh.getId(), resultTrackTime, veh.getVehicleType(), distance));
                } else {
                    throw new IllegalArgumentException("currentRace cannot be null");
                }
            }
        }

        return finalResult;
    }

}
