package com.rifat.racingSimulator.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RaceType raceType;

    private double distance;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(mappedBy = "race", cascade = CascadeType.PERSIST)
    private List<RaceParticipantLink> raceParticipantLinks;

    public Race() {
    }

    public Race(RaceType raceType, double distance) {
        this.raceType = raceType;
        this.distance = distance;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RaceType getRaceType() {
        return this.raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<RaceParticipantLink> getRaceParticipantLinks() {
        return this.raceParticipantLinks;
    }

    public void setRaceParticipantLinks(List<RaceParticipantLink> raceParticipantLinks) {
        this.raceParticipantLinks = raceParticipantLinks;
    }

}
