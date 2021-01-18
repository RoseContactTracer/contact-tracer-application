package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
public class PositiveCase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Column(name = "symptomatic_start_date")
	private Date symptomaticStartDate;

	@Column(name = "test_date", nullable = false)
	private Date testDate;

	@Column(name = "needs_transportation", nullable = false)
	private boolean needsTransportation = false;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_tracer_id")
	private ContactTracer contactTracer;

	public PositiveCase() {
	}

	public PositiveCase(Person person, Date testDate, Date symptomaticStartDate, boolean needsTransportation) {
		this.person = person;
		this.testDate = testDate;
		this.symptomaticStartDate = symptomaticStartDate;
		this.needsTransportation = needsTransportation;
	}

	public Date getSymptomaticStartDate() {
		return symptomaticStartDate;
	}

	public int getID() {
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
}
