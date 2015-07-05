/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author kmhasan
 */
public class SortingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int intArray[] = {4, 2, 1, 5, 6, 23, 13, 4};

        Arrays.sort(intArray);
        
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
        System.out.println();

        double doubleArray[] = {3.225, -1.021, 3, 49.335};

        Arrays.sort(doubleArray);
        for (double d: doubleArray)
            System.out.println(d);
        /*
        for (int i = 0; i < doubleArray.length; i++)
            System.out.print(doubleArray[i] + " ");
        System.out.println();
        */
        
        String stringArray[] = {"the", "quick", "brown", "fox", "jumps", "over", "a", "lazy", "dog"};
        Arrays.sort(stringArray);
        for (String t: stringArray)
            System.out.println(t);
        
        
        Student a = new Student(101, "Abul", 2.54);
        Student b = new Student(151, "Ratul", 3.24);
        Student c = new Student(132, "Tetul", 3.68);
        Student d = new Student(199, "Putul", 3.25);
        Student e = new Student(105, "Kabul", 1.99);
        Student studentArray[] = {a, b, c, d, e};
        IdComparator idComparator = new IdComparator();
        NameComparator nameComparator = new NameComparator();
        Arrays.sort(studentArray, nameComparator);
        for (Student s: studentArray)
            System.out.println(s);
        
        System.out.println("---------");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(a);
        studentList.add(b);
        studentList.add(c);
        studentList.add(d);
        studentList.add(e);
        Collections.sort(studentList, idComparator);
        for (Student s: studentList)
            System.out.println(s);
    }
    
}
