package bd.ac.seu.hibernate;


import javax.persistence.Embeddable;
import javax.persistence.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmhasan
 */
@Embeddable
public class Address {
    private String house;
    private String street;
    private String city;

    public Address() {
    }

    public Address(String house, String street, String city) {
        this.house = house;
        this.street = street;
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" + "house=" + house + ", street=" + street + ", city=" + city + '}';
    }
    
}
