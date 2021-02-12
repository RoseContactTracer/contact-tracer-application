package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

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

enum ROLE {
	PERSON, HEALTH_SERVICES, CONTACT_TRACER, HEAD_CONTACT_TRACER, STUDENT_AFFAIRS, SYSTEM_ADMIN;

	public String toString(){
		switch(this){
			case PERSON:
				return "Person";
			case HEALTH_SERVICES:
				return "Health Services";
			case CONTACT_TRACER:
				return "Contact Tracer";
			case HEAD_CONTACT_TRACER:
				return "Head Contact Tracer";
			case STUDENT_AFFAIRS:
				return "Student Affairs";
			case SYSTEM_ADMIN:
				return "System Admin";
			default:
				return "Role Unspecified";
		}
	}

	public static ROLE roleFromString(String role){
		switch(role){
			case "health services":
				return ROLE.HEALTH_SERVICES;
			case "contact tracer":
				return ROLE.CONTACT_TRACER;
			case "head contact tracer":
				return ROLE.HEAD_CONTACT_TRACER;
			case "student affairs":
				return ROLE.STUDENT_AFFAIRS;
			case "system admin":
				return ROLE.SYSTEM_ADMIN;
			default:
				return ROLE.PERSON;
		}
	}
}
