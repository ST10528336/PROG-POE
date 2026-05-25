/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author Student
 */
public class LoginClass {
    private String userName;
    private String passWord;
    private String cellPhonenumber;
    private String firstName;
    private String lastName;
    
    //getters and setters 
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
      return this.firstName;  
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
       return this.lastName; 
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setPassword(String passWord){
        this.passWord = passWord;
    }
    public String getPassword(){
        return this.passWord;
    }
    public void setCellPhoneNumber(String cellPhonenumber){
        this.cellPhonenumber = cellPhonenumber;
    }
    public String getCellPhoneNumber(){
        return this.cellPhonenumber;
    }
    //calling a method to ensure that the username contains an underscore and is no more than 5 characters
    public boolean checkUsername (String userName){
        if (userName.length()<=5 && userName.contains("_")){
         return true;   
        }
        else{
            System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length.");
             return false;      
        }
    }
        //calling another method to ensure that the password contains at least 8 characters ,contain a number,a letter and has a special character
    public boolean checkPassword(String passWord){
        if (passWord.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$")){
             return true;
        }  
        else{
            System.out.println("Password is not correctly formatted;please ensure that the password contain at least eight characters,a capital letter,a number,and a special character.");
            return false;
        }  
    }    
        //calling a method to check if the cellphone number is 10 digit long and consist the international code
    public boolean checkCellPhoneNumber(String cellPhonenumber){
        if (cellPhonenumber.matches("^\\+27\\d{9}$")) {
            return true;
        } else {
            System.out.println("Cell number is incorrectly formatted or does not contain the international code;Please correct the number and try again.");
            return false;
        }
    }
       //calling a method to register user
    public String registerUser(String userName, String passWord, String cellPhonenumber){
        if (!checkUsername(userName)){
            return "Registration failed: Invalid username.";
        }
        if(!checkPassword(passWord)){
            return "Registration failed: Invalid password.";
        }
        if(!checkCellPhoneNumber(cellPhonenumber)){
            return "Registration failed: Invalid cellphone number.";
        }
        this.userName = userName;
        this.passWord = passWord;
        this.cellPhonenumber = cellPhonenumber;
        
        return "User successfully registered.";
    }
       //calling a method for login check
    public boolean loginUser(String userName , String passWord){
       return this.userName.equals(userName) && this.passWord.equals(passWord);
    
    }
      //calling a to return necessary message for a successful login or a failed login
    public String returnLoginstatus(boolean loginSuccess){
        if (loginSuccess){
            return "Welcome :" + userName + "it is great to see you again.";
        }
        else{
            return "Username or password incorrect , please try again.";
        }
    }
}
