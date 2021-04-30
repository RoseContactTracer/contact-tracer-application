package edu.rosehulman.covidtracer.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class UserRole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@Column(name = "Role", nullable = false, unique = true)
	private ROLES role;

	public UserRole() {}

	public UserRole(String role) {
		this.role = ROLES.roleFromString(role);
	}

	public Long getID() {
		return ID;
	}

	public String getRole() {
		return role.toString();
	}

}

enum ROLES {
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

	public static ROLES roleFromString(String role){
		switch(role){
			case "health services":
				return ROLES.HEALTH_SERVICES;
			case "contact tracer":
				return ROLES.CONTACT_TRACER;
			case "head contact tracer":
				return ROLES.HEAD_CONTACT_TRACER;
			case "student affairs":
				return ROLES.STUDENT_AFFAIRS;
			case "system admin":
				return ROLES.SYSTEM_ADMIN;
			default:
				return ROLES.PERSON;
		}
	}
}
