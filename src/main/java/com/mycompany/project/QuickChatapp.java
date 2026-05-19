/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class QuickChatapp {
    public static void main(String[] args){
      //Creating a scanner object
      Scanner scan = new Scanner(System.in);
      //Displaying a welcome message to the user
      System.out.println("Welcome to QuickChat.");
      //Displaying options that the user can use while using this App
      System.out.println("""
                         Please select an option: 
                         1 Send messages
                         2 Show recently sent messages
                         3 Quit""");
      System.out.print("Choice");
      int options = scan.nextInt();
      scan.nextLine();
      
      //switch case
      switch(options){
          case 1:
              System.out.println("Please enter the message you would like to send :");
              String message = scan.nextLine();
              System.out.println("Message sent!");
              break;
          case 2:
              System.out.println("Coming Soon.");
              break;
          case 3:
              System.out.println("Exiting QuickChat.Goodbye!");
              break;
          default:
              System.out.println("Invalid option chosen.Please try again.");
      }
    }
}
