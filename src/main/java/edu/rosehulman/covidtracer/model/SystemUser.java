package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SystemUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Person person;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "Salt", nullable = false)
	private String salt;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	public SystemUser() {
	}

	public SystemUser(Person person, String password, String salt, Role role) {
		this.person = person;
		this.password = password;
		this.salt = salt;
		this.role = role;
	}

	public Person getPerson() {
		return person;
	}

	public int ID() {
		return ID;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public String getSalt() {
		return salt;
	}

}
