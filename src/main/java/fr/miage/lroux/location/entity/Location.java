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

    private long idVoiture;

    private long idUser;

    private long idAccessCard;

    private long idStation;

    public Location() {}

    public Location(long idVoiture, long idUser, long idAccessCard, long idStation) {
        this.idVoiture = idVoiture;
        this.idUser = idUser;
        this.idAccessCard = idAccessCard;
        this.idStation = idStation;
    }

    public Location(long idLocation, long idVoiture, long idUser, long idAccessCard, long idStation) {
        this.idLocation = idLocation;
        this.idVoiture = idVoiture;
        this.idUser = idUser;
        this.idAccessCard = idAccessCard;
        this.idStation = idStation;
    }

    public long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(long idLocation) {
        this.idLocation = idLocation;
    }

    public long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdAccessCard() {
        return idAccessCard;
    }

    public void setIdAccessCard(long idAccessCard) {
        this.idAccessCard = idAccessCard;
    }

    public long getIdStation() {
        return idStation;
    }

    public void setIdStation(long idStation) {
        this.idStation = idStation;
    }
}
