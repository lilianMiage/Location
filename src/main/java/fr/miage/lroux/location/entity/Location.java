package fr.miage.lroux.location.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
public class Location {

    @Id
    @GeneratedValue
    private long idLocation;

    private long carId;

    private long userId;

    private long accessCardId;

    private long stationId;

    @Column(nullable = false)
    private boolean active;


    public Location() {}

    public Location(long carId, long userId, long accessCardId, long stationId) {
        this.carId = carId;
        this.userId = userId;
        this.accessCardId = accessCardId;
        this.stationId = stationId;
    }

    public Location(long idLocation, long carId, long userId, long accessCardId, long stationId) {
        this.idLocation = idLocation;
        this.carId = carId;
        this.userId = userId;
        this.accessCardId = accessCardId;
        this.stationId = stationId;
    }

    public Location(long idLocation, long carId, long userId, long accessCardId, long stationId, boolean active) {
        this.idLocation = idLocation;
        this.carId = carId;
        this.userId = userId;
        this.accessCardId = accessCardId;
        this.stationId = stationId;
        this.active = active;
    }

    public long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(long idLocation) {
        this.idLocation = idLocation;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccessCardId() {
        return accessCardId;
    }

    public void setAccessCardId(long accessCardId) {
        this.accessCardId = accessCardId;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }
}
