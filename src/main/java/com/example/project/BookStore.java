package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[0];
    private User[] users = new User[10];

    //requires 1 empty constructor
    public BookStore () {}

    /* the following methods are getter methods that return the value of the instance variables of 
    the BookStore class (books and users array list) and allows the user to set the users' instant
    variable to a new value that is passed in as the parameter in the setter (void) method */

    public User[] getUsers(){
        return users;
    }

    public void setUsers(User[] newUsers) {
        users = newUsers;
    }

    public Book[] getBooks(){ 
        return books;
    }

    /* This method adds a User type object (inputted as parameter) to the users' array 
    list in the first available index that is null */
    public void addUser(User user){
        // keeps track of the index for the first null value in the list
        int checkEmptySpace = 0;
        // increments "checkEmptySpace" until the value is null
        while (users[checkEmptySpace] != null) {
            checkEmptySpace++;
        }
        // sets the inputted User object to the users' array list in the empty(null) index value
        users[checkEmptySpace] = user;
    } 

    /* This method removes a User type object (inputted as parameter) from the users' array 
    list and then consolidates the list, so that it moves null values to the end of the array. 
    NOTE: The length of the users' list is always unchanged */
    public void removeUser(User user){
        /* finds the inputted User object in the users' array by iterating through the array 
        and removes it by setting it to null */
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                users[i] = null; 
            }
            consolidateUsers();
        }
    }

    // This method moves null values in the users' array to the end of the array.
    public void consolidateUsers(){
        int emptySpot = 0;
        // keeps track of an empty null index, and where the next non-null user should be placed
        for (int i = 0; i < users.length; i++){
            if (users[i] != null){
                if (i != emptySpot){
                    users[emptySpot] = users[i];
                    users[i] = null;
                }
                emptySpot++;
            }
        }
    }

    /* this method adds a Book object, that is inputted by the user in the parameter, 
    to the books' array. This INCREASES the length of the array by one.*/
    public void addBook(Book book) {
        // initializes a new Book array, whose length is one more than the original Book array's length
        Book[] newBooks = new Book[books.length + 1];
        // copies each element from the original array to its corresponding index in newBooks array
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        // sets the last (new added) element of the newBook array to the Book object inputted by user
        newBooks[newBooks.length - 1] = book;
        // assings the Book array the same memory address (reference) as the newBooks array
        books = newBooks;
    }
     
    /* This method inserts a Book object inputted by the user into a specified index of the books' array. 
       This INCREASES the length of the array by one. */ 
    public void insertBook(Book book, int index){
            // initializes insertOne to a Book array with length that is one greater than the original
            Book[] insertOne = new Book[books.length + 1];
            /* copies each element in the original array to their new corresponding location. If an object
               was previously in the index >= provided by the user, its index location is incremented by 1. */
            for (int i = 0; i < index; i++) {
                insertOne[i] = books[i];
            }
            for (int i = index; i < books.length; i++) {
                insertOne[i + 1] = books[i];
            }
            // sets and inputs the book passed by the user in the modified array to the specified index
            insertOne[index] = book;
            // assigns the Book array the same memory address (reference) as the insertOne array.
            books = insertOne;
    }

     /* this method removes a quantity of the Book object that is inputted by the user in the parameter, 
    from the books' array. This might DECREASE the length of the array by one.*/
    public void removeBook(Book book){
        // iterates the array and sets "location" to the index that the user inputted Book object is found
        int location = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                location = i;
            }
        }
        /*  checks the quantity of that Book object specified by the user in the array. If the quantity 
            is more than 1, it simply decreases the quantity of that Book object using Book class methods
            by 1. If the quantity is 1, it means that Book type no longer exists in collection and has to 
            be removed hence it is set to null. Then, it creates a newBook array with a length 
            (one less than original books' array length) Then, it copies each value from original array 
            into the newBooks' array, excluding the null value. Lastly, it assigns the Book 
            array the same memory address (reference) as the newBooks array.
         */
        if (books[location].getQuantity() == 1) { 
            Book[] newBooks = new Book[books.length - 1];
            books[location] = null; 
            for (int i = 0; i < location; i++) {
                newBooks[i] = books[i];
            }
            for (int i = location + 1; i < books.length; i++) {
                newBooks[i - 1] = books[i]; 
            }
            books = newBooks;
        } else {
            books[location].setQuantity(books[location].getQuantity() - 1);
        }
    }

     /* This method returns the information of the books array; it stores this 
    information in a String variable called "result". To do so, it iterates 
    through each element of the array and appends the return value of the bookInfo method to that
    specific Book object of the books array index into a new line. Lastly, it will return the result. */
    public String bookStoreBookInfo(){
        String result = "";
        for (int i = 0; i < books.length; i++){
            result += books[i].bookInfo() + "\n";
        }
        return result;
    } //you are not tested on this method but use it for debugging purposes

    /* This method returns the information of the users array; it stores this 
    information in a String variable called "result". To do so, it iterates 
    through each element of the array and checks if it is null. If it is null, it does not append anything.
    Otherwise, it will append the return value of the userInfo method to that specific User object of 
    the users' array index into a new line. Lastly, it will return the result. */
    public String bookStoreUserInfo(){
        String result = "";
        for (int i = 0; i < users.length; i++){
            if (users[i] != null){
                result += users[i].userInfo() + "\n";
            }
        }
        return result;
    } //you are not tested on this method but use it for debugging purposes
}