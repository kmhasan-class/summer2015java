/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

/**
 *
 * @author kmhasan
 */
public class Book {
    private int accessionNumber;
    private String bookName;
    private String author;
    private double price;
    private int year;

    public Book(int accessionNumber, String bookName, String author, double price, int year) {
        this.accessionNumber = accessionNumber;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public int getAccessionNumber() {
        return accessionNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
    
    void printToConsole() {
        System.out.println(this.accessionNumber);
        System.out.println(this.author);
        System.out.println(this.bookName);
        System.out.println(this.price);
        System.out.println(this.year);
    }
    
    public String toString() {
        return this.bookName;
    }

    public String getFullInformation() {
        return this.accessionNumber + "\n" 
                + this.author + "\n"
                + this.bookName + "\n"
                + this.price + "\n"
                + this.year;
    }
}
