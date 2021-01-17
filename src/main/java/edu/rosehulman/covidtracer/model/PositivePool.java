package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID", nullable = false)
	private int ID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Person1ID")
	private Person person;

	@Column(name = "Date")
	private Date date;

	@ManyToMany(mappedBy = "positivePools")
	private Set<Person> people;

	public PositivePool() {
	}

	public PositivePool(int ID, Person person, Date date) {
		this.ID = ID;
		this.person = person;
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public Person getPerson() {
		return person;
	}

	public Date getDate() {
		return date;
	}

}
