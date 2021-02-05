package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CloseContact implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(name = "date_of_contact")
	private Date dateOfContact;
	
	@Column(name = "quarantine_end_date")
	private Date quarantineEndDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "positive_case_id")
	private PositiveCase positiveCase;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_tracer_id")
	private ContactTracer contactTracer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "quarantine_location_id")
	private QuarantineLocation quarantineLocation;

	public CloseContact() {
	}

	public CloseContact(Person person, Date dateOfContact, Date quarantineEndDate, PositiveCase positiveCase) {
		this.person = person;
		this.dateOfContact = dateOfContact;
		this.quarantineEndDate = quarantineEndDate;
		this.positiveCase = positiveCase;
	}

	public Long getID() {
		return ID;
	}

	public Person getPerson() {
		return person;
	}

	public Date getDateOfContact() {
		return dateOfContact;
	}

	public Date getQuarantineEndDate() {
		return quarantineEndDate;
	}

	public PositiveCase getPositiveCase() {
		return positiveCase;
	}

	public void setContactTracer(ContactTracer contactTracer) {
		this.contactTracer = contactTracer;
	}

	public void setQuarantineLocation(QuarantineLocation quarantineLocation) {
		this.quarantineLocation = quarantineLocation;
	}

}
