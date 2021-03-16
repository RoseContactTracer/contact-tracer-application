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
	private ROLE role;

	public UserRole() {}

	public UserRole(String role) {
		this.role = ROLE.roleFromString(role);
	}

	public Long getID() {
		return ID;
	}

	public String getRole() {
		return role.toString();
	}

}
