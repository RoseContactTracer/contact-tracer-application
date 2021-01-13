package edu.rosehulman.covidtracer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HousingLocation implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int ID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PersonID")
    private Person person;
	
	@Column(name = "Address")
	private String address;
	
	public HousingLocation() {}
	
	public HousingLocation(Person person, String address) {
		this.person = person;
		this.address = address;
	}

	public int getID() {
		return ID;
	}

	public Person getPerson() {
		return person;
	}

	public String getAddress() {
		return address;
	}
}
