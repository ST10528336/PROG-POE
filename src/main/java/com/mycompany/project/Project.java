/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.project;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class Project {

    public static void main(String[] args) {
        
        //Creating a Scanner object
        Scanner scan = new Scanner(System.in);
        //Creating an Object
        LoginClass stdPoe = new LoginClass();
        System.out.println("===Registration===");
        System.out.println("Create a username that contains an underscore and is no more than five characters long :");
        String userName = scan.nextLine();
        stdPoe.setUserName(userName);
        System.out.println("Create a password that contains of at least 8 letters,a number and a special Character :");
        String passWord = scan.nextLine();
        stdPoe.setPassword(passWord);
        System.out.println("Enter your cellphone number (+27...) :");
        String cellPhonenumber = scan.nextLine();
        stdPoe.setCellPhoneNumber(cellPhonenumber);
        
        System.out.println(stdPoe.registerUser(userName, passWord, cellPhonenumber));
          System.out.println("\n===Login===");
         System.out.println("Enter your user name :");
         String loginUser = scan.nextLine();
         System.out.println("Enter your password :");
         String loginpassWord = scan.nextLine();
        
         boolean success = stdPoe.loginUser(userName, passWord);
         
         System.out.println(stdPoe.returnLoginstatus(success));
    }
   
    
}
