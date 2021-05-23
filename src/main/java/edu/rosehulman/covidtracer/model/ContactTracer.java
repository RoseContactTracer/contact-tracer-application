package edu.rosehulman.covidtracer.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ContactTracer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Person person;

	@Column(name = "MAX_CASES", nullable = false)
	private int maxCases;
	
	public ContactTracer() {}
	
	public ContactTracer(Long ID, Person person) {
		this.ID = ID;
		this.person = person;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Person getUser() {
		return person;
	}

	public void setUser(Person person) {
		this.person = person;
	}

	public double findCaseRatio() {
		//need to find the number of cases
		return - 1.9;
	}

	public void assignCase(PositiveCase covidCase) {
	}

	public int getMaxCases() {
		return this.maxCases;
	}
}
