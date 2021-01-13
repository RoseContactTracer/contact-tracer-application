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
import javax.persistence.ManyToOne;

@Entity
public class CloseContact implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", nullable = false)
    private int ID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PersonID")
    private Person person;
	
	@Column(name = "DateOfContact")
	private Date dateOfContact;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PositiveCaseID")
	private PositiveCase positiveCase;
	
	public CloseContact() {}

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
