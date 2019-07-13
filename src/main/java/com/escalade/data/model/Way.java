package com.escalade.data.model;

import javax.persistence.*;

@Entity
@Table(name = "way")
public class Way {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "way_id")
	private int wayId;


	@Column(name = "sector_id")
	private int sectorId;

	@Column(name = "name")
	private String name;

	//cotation, difficulté de la voie
	@Column(name = "cotation")
	private String cotation;

	@Column(name = "total_size")
	private Double totalSize;

	@Column(name = "nb_part")
	private Integer nbPart;

	public Way() {}

	public Way(int sectorId, String name, String cotation, Double totalSize, Integer nbPart) {
		this.sectorId = sectorId;
		this.name = name;
		this.cotation = cotation;
		this.totalSize = totalSize;
		this.nbPart = nbPart;
	}

	public int getWayId() {
		return wayId;
	}

	public void setWayId(int wayId) {
		this.wayId = wayId;
	}

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public Double getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Double totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getNbPart() {
		return nbPart;
	}

	public void setNbPart(Integer nbPart) {
		this.nbPart = nbPart;
	}
}