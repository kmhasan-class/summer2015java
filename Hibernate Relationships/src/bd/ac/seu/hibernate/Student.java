package bd.ac.seu.hibernate;


import bd.ac.seu.hibernate.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmhasan
 */
@Entity
public class Student {
    @Id
    private String id;
    @Column(columnDefinition="varchar(50)", nullable=false)
    private String name;
    private Date dob;
    @Embedded
    private Address address;
    @ManyToMany
    @JoinTable(name="Registration",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="course_code"))
    private Collection<Course> courses;
    
    public Student() {
        courses = new ArrayList<>();
    }

    public Student(String id, String name, Date dob, Address address) {
        this();
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addCourse(Course course) {
        //this.course = course;
        this.courses.add(course);
    }

}
