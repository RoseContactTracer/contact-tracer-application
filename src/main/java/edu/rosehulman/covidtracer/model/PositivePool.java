package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PositivePool implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long ID;
	
	@ManyToMany(mappedBy = "positivePools", cascade = CascadeType.ALL)
	@Column(name = "person", nullable = false)
	private Set<Person> people = new HashSet<Person>();

	@Column(name = "Date", nullable = false)
	private LocalDate date;

	public PositivePool() {
	}

	public PositivePool(Long ID, Person person, LocalDate date) {
		this.ID = ID;
		this.people.add(person);
		this.date = date;
	}

	public Long getID() {
		return ID;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void addPerson(Person person) {
		this.people.add(person);
	}
	
	public void setDate() {
		System.out.println(java.time.LocalDate.now().toString());
		this.date = java.time.LocalDate.now();
	}

}
