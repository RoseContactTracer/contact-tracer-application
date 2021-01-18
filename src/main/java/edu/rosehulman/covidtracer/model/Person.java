package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "phone")
	private String phoneNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "housing_location_id")
	private HousingLocation housingLocation;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "person_to_positive_pools", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "positive_pool_id", referencedColumnName = "ID"))
	private Set<PositivePool> positivePools;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "person_to_positive_pools", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "positive_pool_id", referencedColumnName = "ID"))
	private Set<QuarantineLocation> quarantineLocations;

	public Person() {
	}

	public Person(String firstName, String middleName, String lastName, String email, String phone, HousingLocation housing) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phone;
		this.housingLocation = housing;
	}

	public int getID() {
		return ID;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public HousingLocation getHousingLocation() {
		return housingLocation;
	}

}
