package com.WhiteBoard.WhiteBoard.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bly01854 on 8/29/2017.
 */

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;


    @ManyToMany
    @JoinTable(name = "teacher_student", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private Set<Staff> teachers = new HashSet<>();

    public Student(){

    }

    public Student(String lastName, String firstName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, Set<Staff> teachers){
        this.firstName = firstName;
        this.lastName = lastName;
        this.teachers = teachers;
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

    public Set<Staff> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Staff> teachers) {
        this.teachers = teachers;
    }
}
