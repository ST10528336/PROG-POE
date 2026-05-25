/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import org.json.simple.JSONObject;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

/**
 *
 * @author Student
 */
public class MessageClass {
    private static int totalMessages=0;
    private String messageId;
    private String recipient;
    private String message;
    private String messageHash;
    private String status;
    private int numMessages;
    
    
    //Constructor
    public MessageClass(String recipient, String message){
        this.messageId = generatemessageId();
        this.recipient= recipient;
        this.message = message;
        this.messageHash= createmessageHash();
    }
    //Generating message id
    private String generatemessageId(){
        Random random = new Random();
         long number = Math.abs(random.nextLong());

        String messageId = String.valueOf(number);

         if(messageId.length()>10){
             messageId = messageId.substring(0,10);
         }
        return messageId;
    }
    //Method to Check Message Id
    public boolean checkmessageId(){
        return messageId.length()<=10;
    }
    //Method to check the recipient number
    public String checkrecipientCell(){
        if(recipient.matches("^\\+27\\d{9}$")){
            return "Cellphone number successfully captured.";
        }
        else{
            return "Cellphone number is incorrectly formatted or does not have an international code.Please enter the correct number,and try again";
        }
    }
    //Method to check the message length
    public String checkmessageLength(){
        if(message.length()<=250){
            return "Message ready to send";
        }
        else{
            int excess = message.length()-250;
            return "Message exceeds 250 characters by" + excess +",Please reduce the size";
        }
    }
    //Method to create a message hash
    public String createmessageHash(){
         String[] words = message.trim().split("\\s+");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageId.substring(0, 2)
                + ":" + totalMessages
                + ":" + firstWord + lastWord;
    }
    //Send/Store/Disregard messages
    public String sentMessage(int option){
        switch (option){
            case 1:
                status = "Sent";
                totalMessages++;
                return "Message successfully sent.";
            case 2:
                status = "Disregarded";
                return "Press 0 to delete the message.";
            case 3:
                status = "Stored";
                storeMessage();
                return "Message successfully stored";
            default :
                return "Invalid option.";
        }
    }
    //Storing a message in JSON
    public void storeMessage(){
        //Creating a JSON object
      JSONObject obj = new JSONObject();
      obj.put("MessageID", messageId);
      obj.put("Recipient", recipient);
      obj.put("Message", message);
      obj.put("Hash", messageHash);
      obj.put("Status", status);
      
      try{
          FileWriter file = new
              FileWriter("storedMessages.json", true);
          file.write(obj.toJSONString());
          file.write("\n");
          file.close();
      }catch(IOException e){
          System.out.println("Error writing to file");
      }
    }
    //Method to print messages sent by the user
    public String printMessages(){
        return "Message ID: "+ messageId+ "\nRecipient: "+ recipient+ "\nMessage: "+ message+ "\nMessage Hash: "+ messageHash+ "\nStatus: "+ status;
    }
    //Method to return total number of messages
    public static int returnTotalMessages(){
        return totalMessages;
    }
    //Getters
    public String getMessageID(){
        return messageId;
    }
    public String getMessageHash(){
        return messageHash;
    }
    public String getRecipient(){
        return recipient;
    }
    public String getMessage(){
        return message;
    }
    public int getNumMessages(){
        return numMessages;
    }
}
