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


    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();

    public Staff(){

    }


    public Staff(String lastName, String firstName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Staff(String firstName, String lastName, Set<Student> students){
        this.firstName = firstName;
        this.lastName = lastName;

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
}
