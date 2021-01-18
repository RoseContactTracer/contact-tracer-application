package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@Column(name = "Role")
	private String role;

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public int getID() {
		return ID;
	}

	public String getRole() {
		return role;
	}

}
