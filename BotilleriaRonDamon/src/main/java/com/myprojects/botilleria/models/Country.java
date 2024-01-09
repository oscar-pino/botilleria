package com.myprojects.botilleria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idCountry;

	@Column(nullable = false, length = 20, unique = true)
	private String name;

	public Country() {
	}

	public Country(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	@Override
	public String toString() {
		return "Country [id=" + idCountry + ", name=" + name + "]";
	}

}
