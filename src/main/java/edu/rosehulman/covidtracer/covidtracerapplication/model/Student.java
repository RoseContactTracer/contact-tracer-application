package edu.rosehulman.covidtracer.covidtracerapplication.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    private Person person;

    @Column(name = "StudentID")
    private String studentID;

    @Column(name = "GreekAffiliation")
    private String greekAffiliation;

    private ArrayList<String> athletics;

    public Student(){}

    public Student(Person person, String studentID, String greek, ArrayList<String> athletics){
        this.person = person;
        this.studentID = studentID;
        this.greekAffiliation = greek;
        this.athletics = athletics;
    }



}
