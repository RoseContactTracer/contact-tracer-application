package edu.rosehulman.covidtracer.covidtracerapplication.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(name = "ID")
    private int ID;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
    private Person person;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Salt", nullable = false)
    private String salt;

    @Column(name = "Role", nullable = false)
    private String role;

    public User(){}

    public User(Person person, String password, String salt, String role){
        this.person = person;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

}
