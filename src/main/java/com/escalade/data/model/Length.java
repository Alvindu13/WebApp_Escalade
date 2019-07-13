package com.escalade.data.model;

import javax.persistence.*;

@Entity
@Table(name = "length")
public class Length {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "length_id")
    private int lengthId;

    @Column(name = "way_id")
    private int wayId;

    @Column(name = "size")
    private Double size;

    @Column(name = "nb_anchor")
    private int nbAnchor;

    @Column(name = "relay_name")
    private String relayName;

    public Length() {
    }

    public Length(int wayId, Double size, int nbAnchor, String relayName) {
        this.wayId = wayId;
        this.size = size;
        this.nbAnchor = nbAnchor;
        this.relayName = relayName;
    }

    public int getLengthId() {
        return lengthId;
    }

    public void setLengthId(int lengthId) {
        this.lengthId = lengthId;
    }

    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public int getNbAnchor() {
        return nbAnchor;
    }

    public void setNbAnchor(int nbAnchor) {
        this.nbAnchor = nbAnchor;
    }

    public String getRelayName() {
        return relayName;
    }

    public void setRelayName(String relayName) {
        this.relayName = relayName;
    }
}
