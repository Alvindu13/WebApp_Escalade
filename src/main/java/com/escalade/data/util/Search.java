package com.escalade.data.util;

public class Search {

    private String location;

    private String cotationMinimum;

    private String cotationMaximum;

    private Integer nbSecteur;

    public Search() {
    }

    public Search(String location, String cotationMinimum, String cotationMaximum, Integer nbSecteur) {
        this.location = location;
        this.cotationMinimum = cotationMinimum;
        this.cotationMaximum = cotationMaximum;
        this.nbSecteur = nbSecteur;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCotationMinimum() {
        return cotationMinimum;
    }

    public void setCotationMinimum(String cotationMinimum) {
        this.cotationMinimum = cotationMinimum;
    }

    public Integer getNbSecteur() {
        return nbSecteur;
    }

    public void setNbSecteur(Integer nbSecteur) {
        this.nbSecteur = nbSecteur;
    }

    public String getCotationMaximum() {
        return cotationMaximum;
    }

    public void setCotationMaximum(String cotationMaximum) {
        this.cotationMaximum = cotationMaximum;
    }
}
