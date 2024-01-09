package com.myprojects.botilleria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idUser;

	@Column(nullable = false, length = 20)
	// @NotBlank(message = "El nombre, es obligatorio")
	private String user;

	@Column(nullable = false)
	// @NotBlank(message = "El password, es obligatorio")
	private String password;

	@ManyToOne
	private Role role;

	@ManyToOne
	private Country country;

	public UserLogin() {
	}

	public UserLogin(String user, String password, Role role, Country country) {

		this.user = user;
		this.password = password;
		this.role = role;
		this.country = country;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Country getCountry() {
		return country;
	}

	public void setPais(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserLogin [idUser=" + idUser + ", user=" + user + ", password=" + password + ", role="
				+ role.getName() + ", country= " + country.getName() + "]";
	}
}
