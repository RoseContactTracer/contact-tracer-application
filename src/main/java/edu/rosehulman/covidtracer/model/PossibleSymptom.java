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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PossibleSymptom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@Column(name = "Name", nullable = false, unique = true)
	private String name;

	@Column(name = "Description")
	private String description;

	public PossibleSymptom(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
