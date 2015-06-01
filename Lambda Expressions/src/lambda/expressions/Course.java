/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

/**
 *
 * @author kmhasan
 */
public class Course {
    private String code;
    private String title;
    private double credits;

    public Course(String code, String title, double credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public double getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + ", credits=" + credits + '}';
    }
}
