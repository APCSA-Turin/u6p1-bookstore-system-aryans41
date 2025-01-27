package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id; 
    private Book[] bookList = new Book[5];

    //requires 1 contructor with two parameters that will initialize the name and id
    public User (String name, String Id) {
        this.name = name;
        this.Id = Id;
    }
 
    /* the following methods are getter (return) and setter (void) methods that return the value of 
    each of the instance variables of the User class and allows the user to set those instant variables 
    to a new value that is passed in as the parameter */
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String newId) {
        Id = newId;
    }

    public Book[] getBooks() {
         return bookList;
    }

    public void setBooks(Book[] newBookList) {
        bookList = newBookList;
    }

    /* This method returns the information of the bookList array for the user; it stores this 
    information in a String variable called "result". To do so, it iterates 
    through each element of the array and checks if it is null. If it is null, it appends "empty" to 
    result on a new line. Otherwise, it will append the return value of the bookInfo method to that
    specific Book object of the bookList index into a new line. Lastly, it will return the result. */
    
    public String bookListInfo() {
        String result = ""; 
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null) {
                result += bookList[i].bookInfo() + "\n"; 
            } else {
                result += "empty\n";
            }
        }
        return result;
    } 

    public void addBook (Book book) {
        boolean spaceFound = false;
        int space = 6;
        while (spaceFound == false) {
            int emptySpace = 0; 
            for (int i = 0; i < bookList.length; i++) {
                if (bookList[i] == null) {
                    spaceFound = true;
                    space = i;
                }
            }
        } 
        bookList[space] = book; 
    }

    /* This method returns the information regarding a specfic User object of the User class utilzing the 
    instance variables in the format "Name: []\nID: []\nBooks:\n[]". This helps create a profile for
    an indivdual, that contains the name, Id, and the Book record of the user */

    public String userInfo() {
        return "Name: " + name + "\n" + "Id: " + Id + "\n" + "Books: " + "\n" + bookListInfo();
    } 
}