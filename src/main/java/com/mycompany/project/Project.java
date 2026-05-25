/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.project;
import java.util.Random;
import java.util.Scanner;

public class Project {

    // Global Scanner object
    static Scanner input = new Scanner(System.in);

    // Global variable
    static int totalMessagesSent = 0;
    static String recentMessage= "";
    public static void main(String[] args) {

        // Creating Login Object
        LoginClass stdPoe = new LoginClass();

        // ================= REGISTRATION =================
        System.out.println("=== REGISTRATION ===");

        System.out.println("Create a username that contains an underscore and is no more than five characters long:");
        String userName = input.nextLine();
        stdPoe.setUserName(userName);

        System.out.println("Create a password that contains at least 8 characters, a number and a special character:");
        String passWord = input.nextLine();
        stdPoe.setPassword(passWord);

        System.out.println("Enter your cellphone number (+27...):");
        String cellPhoneNumber = input.nextLine();
        stdPoe.setCellPhoneNumber(cellPhoneNumber);

        // Register user
        String registrationMessage = stdPoe.registerUser(userName, passWord, cellPhoneNumber);

        System.out.println(registrationMessage);

        // Continue only if registration successful
        if (registrationMessage.equals("User successfully registered.")) {

            // ================= LOGIN =================
            System.out.println("\n=== LOGIN ===");

            System.out.println("Enter your username:");
            String loginUser = input.nextLine();

            System.out.println("Enter your password:");
            String loginPassword = input.nextLine();

            // Login check
            boolean success = stdPoe.loginUser(loginUser, loginPassword);

            System.out.println(stdPoe.returnLoginstatus(success));

            // ================= QUICKCHAT =================
            if (success) {

                System.out.println("\nWelcome to QuickChat.");

                // Ask user how many messages to send
                System.out.println("How many messages would you like to send?");
                int maxMessages = input.nextInt();
                input.nextLine();

                int choice;

                do {

                    // Menu
                    System.out.println("""
                                       
                                       === MENU ===
                                       1 Send Messages
                                       2 Show recently sent messages
                                       3 Quit
                                       """);

                    System.out.println("Choose an option:");
                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {

                        case 1:

                            for (int i = 0; i < maxMessages; i++) {

                                totalMessagesSent++;

                                System.out.println("\nMessage " + totalMessagesSent);

                                // Generate Message ID
                                long messageId = generateMessageId();

                                // Recipient number
                                System.out.println("Enter recipient number:");
                                String recipient = input.nextLine();

                                // Validate recipient number
                                while (!recipient.matches("^\\+\\d{10,13}$")) {

                                    System.out.println("Cellphone number incorrectly formatted.");
                                    System.out.println("Please re-enter recipient number:");

                                    recipient = input.nextLine();
                                }

                                // Enter message
                                System.out.println("Enter your message:");
                                String message = input.nextLine();

                                // Prevent empty message
                                while (message.trim().isEmpty()) {

                                    System.out.println("Message cannot be empty.");
                                    System.out.println("Enter your message:");

                                    message = input.nextLine();
                                }

                                // Validate message length
                                if (message.length() > 250) {

                                    System.out.println("Message must be less than 250 characters.");

                                } else {

                                    // Message options
                                    System.out.println("""
                                                       
                                                       1 Send Message
                                                       2 Disregard Message
                                                       3 Store Message
                                                       """);

                                    System.out.println("Choose option:");
                                    int messageOption = input.nextInt();
                                    input.nextLine();

                                    switch (messageOption) {

                                        case 1:

                                            System.out.println("Message successfully sent.");
                                                recentMessage = message;
                                            String messageHash = createMessageHash(
                                                    messageId,
                                                    totalMessagesSent,
                                                    message
                                            );

                                            System.out.println("\n=== MESSAGE DETAILS ===");
                                            System.out.println("Message ID: " + messageId);
                                            System.out.println("Recipient: " + recipient);
                                            System.out.println("Message: " + message);
                                            System.out.println("Message Hash: " + messageHash);
                                            System.out.println("Total Messages Sent: " + totalMessagesSent);
                                            break;

                                        case 2:

                                            System.out.println("Message deleted.");
                                            break;

                                        case 3:

                                            System.out.println("Message stored.");
                                            break;

                                        default:

                                            System.out.println("Invalid option.");
                                    }
                                }
                            }

                            break;

                        case 2:
                            System.out.println("\n=== RECENT MESSAGE ===");

                             if (recentMessage.isEmpty()) {

                                 System.out.println("No messages sent yet.");

                            } else {

                                  System.out.println(recentMessage);
                            }

                            break;

                        case 3:

                            System.out.println("Exiting QuickChat...");
                            break;

                        default:

                            System.out.println("Invalid option.");
                    }

                } while (choice != 3);
            }

        } else {

            System.out.println("Registration failed.");
        }
    }

    // Method to generate random 10-digit Message ID
    public static long generateMessageId() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return number;
    }

    // Method to create Message Hash
    public static String createMessageHash(
            long messageId,
            int messageNumber,
            String message
    ) {

        // First 2 digits of Message ID
        String idPart = String.valueOf(messageId).substring(0, 2);

        // Split message into words
        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String messageHash = idPart + ":"
                + messageNumber + ":"
                + firstWord + ":"
                + lastWord;

        return messageHash.toUpperCase();
    }
}
