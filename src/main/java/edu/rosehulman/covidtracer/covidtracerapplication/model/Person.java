package edu.rosehulman.covidtracer.covidtracerapplication.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(nullable = false)
    private int ID;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    private String email;

    @Column(name = "Phone")
    private String phoneNumber;

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


}
