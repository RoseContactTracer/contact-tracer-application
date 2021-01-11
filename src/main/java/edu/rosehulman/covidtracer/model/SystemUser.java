package edu.rosehulman.covidtracer.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SystemUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "systemUserID")
    private int systemUserIDID;

    @OneToOne(fetch = FetchType.EAGER)
    private Person person;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Salt", nullable = false)
    private String salt;

    @Column(name = "Role", nullable = false)
    private String role;

    public SystemUser(){}

    public SystemUser(Person person, String password, String salt, String role){
        this.person = person;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public int getSystemUserIDID() {
        return systemUserIDID;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getSalt() {
        return salt;
    }
}
