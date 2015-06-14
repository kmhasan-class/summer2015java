package bd.ac.seu.hibernate;


import bd.ac.seu.hibernate.Address;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private String name;
    private Date dob;
    @Embedded
    private Address address;
    @OneToOne
    private Course course;
    
    public Student() {
    }

    public Student(String id, String name, Date dob, Address address) {
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

    public void setCourse(Course course) {
        this.course = course;
    }

}
