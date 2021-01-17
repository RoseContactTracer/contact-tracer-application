package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class QuarantineLocation implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
    private int ID;
	
	@ManyToMany(mappedBy = "quarantineLocations")
	private Set<Person> people;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "RoomIdentifier")
	private String roomIdentifier;
	
	@Column(name = "isFull")
	private boolean isFull;
	
	@Column(name = "isClean")
	private boolean isClean;
	
	public QuarantineLocation(Person person, String address, String roomIdentifier, boolean isFull, boolean isClean) {
		this.people.add(person);
		this.address = address;
		this.roomIdentifier = roomIdentifier;
		this.isFull = isFull;
		this.isClean = isClean;
	}

	public int getID() {
		return ID;
	}

	public Set<Person> getPerson() {
		return people;
	}

	public String getAddress() {
		return address;
	}

	public String getRoomIdentifier() {
		return roomIdentifier;
	}

	public boolean isFull() {
		return isFull;
	}

	public boolean isClean() {
		return isClean;
	}
	
}
