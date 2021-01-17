package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HousingLocation implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
    private int ID;
	
	@OneToMany(mappedBy = "housingLocations")
    @Column(name = "person_id")
    private Set<Person> people;
	
	@Column(name = "Address")
	private String address;
	
	public HousingLocation() {}
	
	public HousingLocation(Person person, String address) {
		this.people.add(person);
		this.address = address;
	}

	public int getID() {
		return ID;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public String getAddress() {
		return address;
	}
	
}
