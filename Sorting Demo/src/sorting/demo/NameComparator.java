/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.demo;

import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class NameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        
        //if (s1.getId() < s2.getId())
        if (s1.getName().compareTo(s2.getName()) < 0)
            return -1;
        else if (s1.getName().compareTo(s2.getName()) > 0)
            return +1;
        else return 0;
    }
    
}
