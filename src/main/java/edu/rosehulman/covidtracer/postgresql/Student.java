package edu.rosehulman.covidtracer.postgresql;

public class Student {
	
	private Integer id;
	private Integer PersonID;
	private String studentID;
	private String GreekAffiliation;
	private String[] Athletics;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPersonID() {
		return PersonID;
	}

	public void setPersonID(Integer personID) {
		PersonID = personID;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getGreekAffiliation() {
		return GreekAffiliation;
	}
	public void setGreekAffiliation(String greekAffiliation) {
		GreekAffiliation = greekAffiliation;
	}
	public String[] getAthletics() {
		return Athletics;
	}
	public void setAthletics(String[] athletics) {
		Athletics = athletics;
	}
	
	
}
