package com.meta.facebook;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.security.UnresolvedPermission;

@Entity
@Table (name = "T_STUDENT")
public class student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column (
            name = "c_fname",
            length = 20
    )
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;


    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private studentProfile studentProfile;

    public com.meta.facebook.studentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(com.meta.facebook.studentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public com.meta.facebook.school getSchool() {
        return school;
    }

    public void setSchool(com.meta.facebook.school school) {
        this.school = school;
    }

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )

    @JsonBackReference
    private school school;



    public student() {
    }

    public student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

}
