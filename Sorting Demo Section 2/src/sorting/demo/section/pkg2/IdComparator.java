/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.demo.section.pkg2;

import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
// Comparator is an Interface
public class IdComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        
        return s1.getId() - s2.getId();
        /*
        if (s1.getId() < s2.getId())
            return -1;
        else if (s1.getId() > s2.getId())
            return +1;
        else return 0;
                */
    }
    
}