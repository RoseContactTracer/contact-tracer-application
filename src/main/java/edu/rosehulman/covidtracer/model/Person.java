package edu.rosehulman.covidtracer.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int personID;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Phone")
    private String phoneNumber;

    @Column(name = "Residence")
    private String residence;

    public Person() {}

    public Person(String firstName, String middleName, String lastName, String email, String phone, String res){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phone;
        this.residence = res;
    }

    public int getPersonID() {
        return personID;
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

    public String getResidence() {
        return residence;
    }
}
