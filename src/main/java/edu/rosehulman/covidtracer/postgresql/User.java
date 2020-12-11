package edu.rosehulman.covidtracer.postgresql;

public class User {
	
	private Integer id;
	private Integer personID;
	private String password;
	private String salt;
	
	public Integer getId() {
		return id;
	}
	public Integer getPersonID() {
		return personID;
	}
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
