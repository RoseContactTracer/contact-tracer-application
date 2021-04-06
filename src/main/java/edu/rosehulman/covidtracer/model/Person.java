package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "rose_id", unique = true)
	private String roseID;

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
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", nullable = false)
	private UserRole role;

	public Person() {
	}

	public Person(String firstName, String middleName, String lastName, String roseID, String email, String phone, HousingLocation housing) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.roseID = roseID;
		this.email = email;
		this.phoneNumber = phone;
		this.housingLocation = housing;
	}
	
	public Person(Long id, String firstName, String middleName, String lastName, String roseID, String email, String phone, HousingLocation housing, UserRole role) {
		this.ID = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.roseID = roseID;
		this.email = email;
		this.phoneNumber = phone;
		this.housingLocation = housing;
		this.role = role;
	}

	public Long getID() {
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
	
	public String getRoseID() {
		return roseID;
	}
	
	public UserRole getRole() {
		return this.role;
	}

	public Set<PositivePool> getPositivePools() {
		return positivePools;
	}

	public void setPositivePools(Set<PositivePool> positivePools) {
		this.positivePools = positivePools;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRoseID(String roseID) {
		this.roseID = roseID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setHousingLocation(HousingLocation housingLocation) {
		this.housingLocation = housingLocation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public HousingLocation getHousingLocation() {
		return housingLocation;
	}

}
