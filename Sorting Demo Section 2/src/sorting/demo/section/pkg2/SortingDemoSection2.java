/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.demo.section.pkg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author kmhasan
 */
public class SortingDemoSection2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {2, 5, -6, 12, 34, 24, 12, 5};
        double doubleArray[] = {3.14159, 2.45, -2.456, 32, 231, 25.9889};
        System.out.println("Before sorting");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        Arrays.sort(array);
        System.out.println("After sorting");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        
        System.out.println("--------------");
        System.out.println("Before Sorting");
        for (int i = 0; i < doubleArray.length; i++)
            System.out.print(doubleArray[i] + " ");
        System.out.println();
        Arrays.sort(doubleArray);
        System.out.println("After Sorting");
        for (double d: doubleArray)
            System.out.print(d + " ");
        System.out.println();
        
        String names[] = {"Amir", "Shamin", "Intiser", "Mohiuddin", "Manch", "Tanvir", "Ishtiaque", "Amlan"};
        Arrays.sort(names);
//        for (int i = 0; i < names.length; i++)
//            System.out.print(names[i] + " ");
        for (String s: names)
            System.out.print(s + " ");
        System.out.println();
        
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("CSE2015");
        courses.add("MATH1024");
        courses.add("MATH1034");
        courses.add("CSE1021");
        courses.add("CSE1011");
        for (String s: courses)
            System.out.print(s + " ");
        System.out.println();
        Collections.sort(courses);
        for (String s: courses)
            System.out.print(s + " ");
        System.out.println();
        
        ArrayList<Student> students = new ArrayList<>();
        Student a = new Student(120, "Abul", 2.33);
        students.add(a);
        students.add(new Student(101, "Babul", 3.45));
        students.add(new Student(136, "Kabul", 3.88));
        students.add(new Student(112, "Ratul", 2.15));
        students.add(new Student(109, "Putul", 2.99));
        students.add(new Student(105, "Tetul", 3.99));
        for (Student s: students)
            System.out.println(s);
        
        // I am not going to explain Lambda expressions here
        //Collections.sort(students, (s1, s2) -> s1.getId() - s2.getId());
        
        IdComparator idComparator = new IdComparator();
        CGPAComparator cgpaComparator = new CGPAComparator();
        Collections.sort(students, cgpaComparator);
        for (Student s: students)
            System.out.println(s);
    }
    
}
