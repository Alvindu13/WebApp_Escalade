package com.escalade.data.model;

import javax.persistence.*;

@Entity
@Table(name = "sector")
public class Sector {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sector_id")
    private int sectorId;

    @Column(name = "site_id")
    private Integer siteId;

    @Column(name = "name")
    private String name;

    public Sector() {}

    public Sector(Integer siteId, String name) {
        this.siteId = siteId;
        this.name = name;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "sectorId=" + sectorId +
                ", siteId=" + siteId +
                ", name='" + name + '\'' +
                '}';
    }
}
