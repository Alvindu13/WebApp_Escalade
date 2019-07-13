package com.escalade.data.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "TOPO")
public class Topo  {



	@ManyToOne(optional=false)
	@JoinColumn(name="user_escalad_id")
	private UserEscalad userEscalad;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOPO_ID")
	private int topoId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CURRENTLY_USER_ESCALAD_ID")
	private Integer userEscaladCurrentProprio;

	@Column(name = "AVAILABLE")
	private Boolean available;

	@Column(name = "RESERVE")
	private Boolean reserve;


	public Topo() {}

	public Topo(UserEscalad userEscalad, String name, Integer userEscaladCurrentProprio, Boolean available, Boolean reserve) {
		this.userEscalad = userEscalad;
		this.name = name;
		this.userEscaladCurrentProprio = userEscaladCurrentProprio;
		this.available = available;
		this.reserve = reserve;
	}

	public UserEscalad getUserEscalad() {
		return userEscalad;
	}

	public void setUserEscalad(UserEscalad userEscalad) {
		this.userEscalad = userEscalad;
	}

	public int getTopoId() {
		return topoId;
	}

	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserEscaladCurrentProprio() {
		return userEscaladCurrentProprio;
	}

	public void setUserEscaladCurrentProprio(Integer userEscaladCurrentProprio) {
		this.userEscaladCurrentProprio = userEscaladCurrentProprio;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean getReserve() {
		return reserve;
	}

	public void setReserve(Boolean reserve) {
		this.reserve = reserve;
	}



	@Override
	public String toString() {
		return "Topo{" +
				"userEscalad=" + userEscalad +
				", topoId=" + topoId +
				", name='" + name + '\'' +
				", userEscaladCurrentProprio=" + userEscaladCurrentProprio +
				", available=" + available +
				", reserve=" + reserve +
				'}';
	}
}