package com.escalade.data.model;

import javax.persistence.*;


@Entity
@Table(name = "user_escalad")
public class UserEscalad {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "user_escalad_id")
	private int userEscaladId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private Integer enabled;


	public UserEscalad() {
		super();
	}


	public UserEscalad(String userName, String firstName, String lastName, String password, Integer enabled) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public int getUserEscaladId() {
		return userEscaladId;
	}

	public void setUserEscaladId(int userEscaladId) {
		this.userEscaladId = userEscaladId;
	}

	@Override
	public String toString() {
		return "UserEscalad{" +
				"userEscaladId=" + userEscaladId +
				", userName='" + userName + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				'}';
	}
}