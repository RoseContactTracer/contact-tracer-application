package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@Column(name = "Role", nullable = false, unique = true)
	private String role;

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public Long getID() {
		return ID;
	}

	public String getRole() {
		return role;
	}

}
