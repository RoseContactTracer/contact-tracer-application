package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int tableStudentID;


    @Column(name = "StudentID")
    private String studentID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;



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

    public Person getPerson() {
        return person;
    }

    public ArrayList<String> getAthletics() {
        return athletics;
    }

    public String getGreekAffiliation() {
        return greekAffiliation;
    }

    public String getStudentID() {
        return studentID;
    }

}
