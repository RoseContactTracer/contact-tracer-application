package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Symptom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PersonID")
	private Person person;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "possible_symptom_to_symptom", joinColumns = @JoinColumn(name = "symptom_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "possible_symptom_id", referencedColumnName = "ID"))
	private PossibleSymptom possibleSymptom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "positive_case_to_symptom", joinColumns = @JoinColumn(name = "symptom_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "positive_case_id", referencedColumnName = "ID"))
	private PositiveCase positiveCase;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "close_contact_to_symptom", joinColumns = @JoinColumn(name = "symptom_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "close_contact_id", referencedColumnName = "ID"))
	private CloseContact closeContact;

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
