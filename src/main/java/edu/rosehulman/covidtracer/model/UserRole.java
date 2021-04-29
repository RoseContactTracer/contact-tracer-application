package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserRole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@Column(name = "Role", nullable = false, unique = true)
	private ROLES ROLES;

	public UserRole() {}

	public UserRole(String role) {
		this.ROLES = ROLES.roleFromString(role);
	}

	public Long getID() {
		return ID;
	}

	public String getRole() {
		return ROLES.toString();
	}

}
