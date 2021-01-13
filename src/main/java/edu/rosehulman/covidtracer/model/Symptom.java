package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Symptom implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", nullable = false)
    private int ID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PersonID")
    private Person person;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SymptomID")
    private PossibleSymptom possibleSymptom;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CaseID")
    private PositiveCase positiveCase;
	
	@Column(name = "OnsetDate")
	private Date onsetDate;
	
	public Symptom(Person person, PossibleSymptom possibleSymptom, PositiveCase positiveCase, Date onsetDate) {
		this.person = person;
		this.possibleSymptom = possibleSymptom;
		this.positiveCase = positiveCase;
		this.onsetDate = onsetDate;
	}

	public int getID() {
		return ID;
	}

	public Person getPerson() {
		return person;
	}

	public PossibleSymptom getPossibleSymptom() {
		return possibleSymptom;
	}

	public PositiveCase getPositiveCase() {
		return positiveCase;
	}

	public Date getOnsetDate() {
		return onsetDate;
	}
	
}
