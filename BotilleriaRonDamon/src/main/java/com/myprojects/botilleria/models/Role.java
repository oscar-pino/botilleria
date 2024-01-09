package com.myprojects.botilleria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long idRole;
	
	@Column(nullable=false, length=20, unique=true)
	//@NotBlank(message = "El rol, es obligatorio")
	private String name;	
	
	public Role() {
	}	
	
	public Role(String name) {
		this.name = name;
	}

	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [idRol=" + idRole + ", nombre=" + name + "]";
	}	
}

