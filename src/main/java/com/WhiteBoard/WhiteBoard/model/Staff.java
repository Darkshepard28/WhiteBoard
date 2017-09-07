package com.WhiteBoard.WhiteBoard.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bly01854 on 8/29/2017.
 */
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    @OneToOne
    private Institution institution;


    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();

    public Staff(){

    }


    public Staff(String lastName, String firstName, Institution institution){
        this.firstName = firstName;
        this.lastName = lastName;
        this.institution = institution;
    }

    public Staff(String firstName, String lastName, Institution institution, Set<Student> students){
        this.firstName = firstName;
        this.lastName = lastName;
        this.institution = institution;
        this.students = students;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
