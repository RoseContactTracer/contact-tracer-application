package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Entity
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(name = "GreekAffiliation")
	private String greekAffiliation;

	@Column(name = "Athletics")
	private ArrayList<String> athletics;
	
	@Column(name = "Other")
	private String otherInfo;

	public Student() {
	}

	public Student(Person person, String greek, ArrayList<String> athletics) {
		this.person = person;
		this.greekAffiliation = greek;
		this.athletics = athletics;
	}

	public Long getID() {
		return ID;
	}

	public Person getPerson() {
		return person;
	}

	public ArrayList<String> getAthletics() {
		return athletics;
	}

	public String getGreekAffiliation() {
		return greekAffiliation;
	}

}
