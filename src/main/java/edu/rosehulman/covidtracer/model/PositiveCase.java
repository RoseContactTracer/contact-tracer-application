package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class PositiveCase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Column(name = "test_date", nullable = false)
	private Date testDate;
	
	@Column(name = "symptomatic_start_date")
	private Date symptomaticStartDate;
	
	@Column(name = "quarantine_end_date")
	private Date quarantineEndDate;

	@Column(name = "needs_transportation", nullable = false)
	private boolean needsTransportation = false;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_tracer_id")
	private ContactTracer contactTracer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "quarantine_location_id")
	private QuarantineLocation quarantineLocation;

	public PositiveCase() {
	}

	public PositiveCase(Long ID, Person person, Date testDate, Date symptomaticStartDate, Date endOfQuarentineDate, boolean needsTransportation) {
		this.ID = ID;
		this.person = person;
		this.testDate = testDate;
		this.symptomaticStartDate = symptomaticStartDate;
		this.quarantineEndDate = quarantineEndDate;
		this.needsTransportation = needsTransportation;
	}

	public Date getQuarantineEndDate() {
		return quarantineEndDate;
	}

	public Date getSymptomaticStartDate() {
		return symptomaticStartDate;
	}

	public Long getID() {
		return ID;
	}

	public Date getTestDate() {
		return testDate;
	}

	public Person getPerson() {
		return person;
	}

	public boolean isNeedsTransportation() {
		return needsTransportation;
	}
	
	public void setContactTracer(ContactTracer tracer) {
		this.contactTracer = tracer;
	}

	public void setQuarantineLocation(QuarantineLocation quarantineLocation) {
		this.quarantineLocation = quarantineLocation;
	}

	public ContactTracer getContactTracer() {
		return contactTracer;
	}

	public QuarantineLocation getQuarantineLocation() {
		return quarantineLocation;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public void setSymptomaticStartDate(Date symptomaticStartDate) {
		this.symptomaticStartDate = symptomaticStartDate;
	}

	public void setQuarantineEndDate(Date quarantineEndDate) {
		this.quarantineEndDate = quarantineEndDate;
	}

	public void setNeedsTransportation(boolean needsTransportation) {
		this.needsTransportation = needsTransportation;
	}
	
}
