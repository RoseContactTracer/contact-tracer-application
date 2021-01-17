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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "person_to_positive_case", joinColumns = @JoinColumn(name = "positive_case_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "ID"))
	private Person person;

	private Date symptomaticStartDate;

	private Date testDate;

	private boolean needsTransportation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "contact_tracer_to_positive_case", joinColumns = @JoinColumn(name = "PositiveCaseID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "contact_tracer_id", referencedColumnName = "ID"))
	private ContactTracer contactTracer;
	
	@OneToMany(mappedBy = "contactTracer")
    @Column(name = "close_contact_id")
    Set<CloseContact> closeContacts;
	
	@OneToMany(mappedBy = "ID")
    @Column(name = "symptom_id")
    private Set<Symptom> symptoms;

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
}
