package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID", nullable = false)
	private int ID;
	
	@ManyToMany(mappedBy = "positivePools", cascade = CascadeType.ALL)
	@Column(name = "person", nullable = false)
	private Set<Person> people;

	@Column(name = "Date", nullable = false)
	private Date date;

	public PositivePool() {
	}

	public PositivePool(int ID, Person person, Date date) {
		this.ID = ID;
		this.people.add(person);
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public Date getDate() {
		return date;
	}

}
