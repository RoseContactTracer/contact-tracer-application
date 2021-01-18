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

	@Column(name = "Address")
	private String address;

	public HousingLocation() {
	}

	public HousingLocation(String address) {
		this.address = address;
	}

	public int getID() {
		return ID;
	}

	public String getAddress() {
		return address;
	}

}
