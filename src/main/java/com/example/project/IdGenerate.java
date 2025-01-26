package com.example.project;

public class IdGenerate{ 
    //This class contains statics variable and methods, you do not initalize an object to use it.
    private static String currentId = "99";
    // //requires 1 private attribute String currentId. You must initialize it to 99

    // //requires one empty constructor
    private IdGenerate() {}

    // this getter method returns the most recent value of the instance variable "currentId"
    public static String getCurrentId(){
        return currentId;
    }

    //This method resets the currentId back to 99
    public static void reset(){
        currentId = "99"; 
    }

    /* This method generates a new id, when called it will increment the currentId by 1. To increment, 
    it must first extract the String data type of currentId into an integer using the "parseInt" method
    and then increment that value. Lastly, it would set the currentId into the String data type of the 
    incremented value */
    public static void generateID(){
        int id = Integer.parseInt(currentId); 
        id++;
        currentId = "" + id;
    } 
}