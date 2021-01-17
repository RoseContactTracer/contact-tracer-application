package edu.rosehulman.covidtracer.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ContactTracer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, columnDefinition = "serial")
	private int ID;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private SystemUser user;

	@OneToMany(mappedBy = "ID")
	@Column(name = "positive_case_id")
	Set<PositiveCase> positiveCases;

	@OneToMany(mappedBy = "ID")
	@Column(name = "positive_case_id")
	Set<CloseContact> closeContacts;

}
