package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SystemUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@OneToOne(fetch = FetchType.EAGER)
	private Person person;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "Salt", nullable = false)
	private String salt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "sys_user_to_role", joinColumns = @JoinColumn(name = "sys_user_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID"))
	private Role role;

	@OneToOne(mappedBy = "user")
	private ContactTracer contactTracer;

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
