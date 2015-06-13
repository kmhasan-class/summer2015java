/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author kmhasan
 */
@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private String address;
    private double cgpa;

    public Student() {
    }

    public Student(String id, String name, String address, double cgpa) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cgpa = cgpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", address=" + address + ", cgpa=" + cgpa + '}';
    }
}
