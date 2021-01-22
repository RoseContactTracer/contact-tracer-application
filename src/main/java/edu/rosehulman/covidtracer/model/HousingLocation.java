package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HousingLocation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@Column(name = "Address", nullable = false, unique = true)
	private String address;

	public HousingLocation() {
	}

	public HousingLocation(String address) {
		this.address = address;
	}

	public Long getID() {
		return ID;
	}

	public String getAddress() {
		return address;
	}

}
