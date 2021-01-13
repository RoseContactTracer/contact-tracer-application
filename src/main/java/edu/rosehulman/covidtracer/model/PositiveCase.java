package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class PositiveCase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private Date symptomaticStartDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;
    
    private Date testDate;

    private boolean needsTransportation;

    public PositiveCase() {}
    
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
