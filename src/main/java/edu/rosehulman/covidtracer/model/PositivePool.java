package edu.rosehulman.covidtracer.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PositivePool implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int ID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Person1ID")
    private Person person1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Person2ID")
    private Person person2;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Person3ID")
    private Person person3;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Person4ID")
    private Person person4;
	
	@Column(name = "Date")
	private Date date;
	
	public PositivePool() {}
	
	public PositivePool(Person person1, Person person2, Person person3, Person person4, Date date) {
		this.person1 = person1;
		this.person2 = person2;
		this.person3 = person3;
		this.person4 = person4;
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public Person getPerson1() {
		return person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public Person getPerson3() {
		return person3;
	}

	public Person getPerson4() {
		return person4;
	}

	public Date getDate() {
		return date;
	}
}
