package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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
import javax.persistence.OneToMany;

@Entity
public class CloseContact implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(name = "date_of_contact")
	private Date dateOfContact;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "positive_case_id")
	private PositiveCase positiveCase;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_tracer_id")
	private ContactTracer contactTracer;

	public CloseContact() {
	}

	public CloseContact(Person person, Date dateOfContact, PositiveCase positiveCase) {
		this.person = person;
		this.dateOfContact = dateOfContact;
		this.positiveCase = positiveCase;
	}

	public int getID() {
		return ID;
	}

	public Person getPerson() {
		return person;
	}

	public Date getDateOfContact() {
		return dateOfContact;
	}

	public PositiveCase getPositiveCase() {
		return positiveCase;
	}

}
