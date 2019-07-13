package com.escalade.data.model;

import javax.persistence.*;

@Entity
@Table(name = "SITE")
public class Site {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "site_id")
    private int siteId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "TOPO_ID")
    private int topoId;

    @Column(name = "COTATION_MINIMUM")
    private String cotationMinimum;

    @Column(name = "COTATION_MAXIMUM")
    private String cotationMaximum;


    public Site() { }

    public Site(String name, String location, String comment, int topoId, String cotationMinimum, String cotationMaximum) {
        this.name = name;
        this.location = location;
        this.comment = comment;
        this.topoId = topoId;
        this.cotationMinimum = cotationMinimum;
        this.cotationMaximum = cotationMaximum;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public String getCotationMinimum() {
        return cotationMinimum;
    }

    public void setCotationMinimum(String cotationMinimum) {
        this.cotationMinimum = cotationMinimum;
    }

    public String getCotationMaximum() {
        return cotationMaximum;
    }

    public void setCotationMaximum(String cotationMaximum) {
        this.cotationMaximum = cotationMaximum;
    }

}
