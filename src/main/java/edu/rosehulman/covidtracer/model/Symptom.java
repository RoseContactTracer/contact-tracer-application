package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "possible_symptom_id", nullable = false)
	private PossibleSymptom possibleSymptom;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "positive_case_id")
	private PositiveCase positiveCase;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "close_contact_id")
	private CloseContact closeContact;

	@Column(name = "OnsetDate", nullable = false)
	private Date onsetDate;

	public Symptom(Person person, PossibleSymptom possibleSymptom, PositiveCase positiveCase, Date onsetDate) {
		this.person = person;
		this.possibleSymptom = possibleSymptom;
		this.positiveCase = positiveCase;
		this.onsetDate = onsetDate;
	}

	public Long getID() {
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
