package com.rifat.racingSimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rifat.racingSimulator.model.RaceParticipantLink;

public interface RaceParticipantLinkRepository extends JpaRepository<RaceParticipantLink, Long> {
}
