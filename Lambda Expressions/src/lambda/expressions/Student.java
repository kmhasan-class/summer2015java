/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

import java.time.LocalDate;

/**
 *
 * @author kmhasan
 */
public class Student {
    private String id;
    private String name;
    private Sex sex;
    private LocalDate dob;

    public Student(String id, String name, Sex sex, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return name; //"Student{" + "id=" + id + ", name=" + name + ", sex=" + sex + ", dob=" + dob + '}';
    }
}
