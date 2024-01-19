package com.myprojects.botilleria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyImage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idImage;	
	
	@NotNull
	@NotBlank
	private String rout; 
	
	@NotNull
	@NotBlank
	private String name;	
	
	public Long getIdImage() {
		return idImage;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRout() {
		return rout;
	}
	
	public void setRout(String rout) {
		this.rout = rout;
	}

	@Override
	public String toString() {
		return "MyImage [idImage=" + idImage + ", rout=" + rout + ", nombre=" + name + "]";
	}

	
}

