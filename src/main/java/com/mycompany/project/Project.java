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
public static int totalMessagesSent = 0;
public static String[] sentMessages = new String[100];
public static String[] storedMessages = new String[100];
public static String[] disregardedMessages = new String[100];
public static String[] recipients = new String[100];
public static String[] messageHashes = new String[100];
public static long[] messageIDs = new long[100];
public static int storedCount = 0;
public static int disregardedCount = 0;

    public static void main(String[] args) {

        LoginClass stdPoe = new LoginClass();

        // ================= REGISTRATION =================

        System.out.println("=== REGISTRATION ===");

        System.out.println(
                "Create a username that contains an underscore "
                + "and is no more than five characters long:");

        String userName = input.nextLine();
        stdPoe.setUserName(userName);

        System.out.println(
                "Create a password that contains at least "
                + "8 characters, a number and a special character:");

        String passWord = input.nextLine();
        stdPoe.setPassword(passWord);

        System.out.println("Enter your cellphone number (+27...):");

        String cellPhoneNumber = input.nextLine();
        stdPoe.setCellPhoneNumber(cellPhoneNumber);

        String registrationMessage =
                stdPoe.registerUser(
                        userName,
                        passWord,
                        cellPhoneNumber);

        System.out.println(registrationMessage);

        if (registrationMessage.equals(
                "User successfully registered.")) {

            // ================= LOGIN =================

            System.out.println("\n=== LOGIN ===");

            System.out.println("Enter your username:");
            String loginUser = input.nextLine();

            System.out.println("Enter your password:");
            String loginPassword = input.nextLine();

            boolean success =
                    stdPoe.loginUser(
                            loginUser,
                            loginPassword);

            System.out.println(
                    stdPoe.returnLoginstatus(success));

            if (success) {

                System.out.println(
                        "\nWelcome to QuickChat.");

                int choice;

                do {

                    System.out.println("""
                            
                            === MENU ===
                            1 Send Messages
                            2 Show Sent Messages
                            3 Stored Messages
                            4 Quit
                            """);

                    System.out.println(
                            "Choose an option:");

                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {

                        case 1:

                            sendMessages();
                            break;

                        case 2:

                            showSentMessages();
                            break;

                        case 3:

                            storedMessagesMenu();
                            break;

                        case 4:

                            System.out.println(
                                    "Exiting QuickChat...");
                            break;

                        default:

                            System.out.println(
                                    "Invalid option.");
                    }

                } while (choice != 4);
            }
        }
    }  
public static void showSentMessages() {

    System.out.println(
            "\n=== SENT MESSAGES ===");

    if (totalMessagesSent == 0) {

        System.out.println(
                "No messages sent.");

        return;
    }

    for (int i = 0;
            i < totalMessagesSent;
            i++) {

        System.out.println(
                (i + 1) + ". "
                + sentMessages[i]);
    }
}
public static void sendMessages() {

    long messageId = generateMessageId();

    System.out.println("Enter recipient number:");
    String recipient = input.nextLine();

    while (!recipient.matches("^\\+\\d{10,13}$")) {

        System.out.println("Cellphone number incorrectly formatted.");
        System.out.println("Please re-enter recipient number:");

        recipient = input.nextLine();
    }

    System.out.println("Enter your message:");
    String message = input.nextLine();

    while (message.trim().isEmpty()) {

        System.out.println("Message cannot be empty.");
        message = input.nextLine();
    }

    if (message.length() > 250) {

        System.out.println(
                "Message exceeds 250 characters by "
                + (message.length() - 250)
                + ", please reduce size.");

        return;
    }

    System.out.println("""
                       
                       1 Send Message
                       2 Disregard Message
                       3 Store Message
                       """);

    int option = input.nextInt();
    input.nextLine();

    switch (option) {

        case 1:

            sentMessages[totalMessagesSent] = message;

            recipients[totalMessagesSent] = recipient;

            messageIDs[totalMessagesSent] = messageId;

            messageHashes[totalMessagesSent]
                    = createMessageHash(
                            messageId,
                            totalMessagesSent + 1,
                            message);

            totalMessagesSent++;

            System.out.println("Message successfully sent.");

            break;

        case 2:

            disregardedMessages[disregardedCount]
                    = message;

            disregardedCount++;

            System.out.println("Message deleted.");

            break;

        case 3:

            storedMessages[storedCount]
                    = message;

            recipients[storedCount]
                    = recipient;

            messageIDs[storedCount]
                    = messageId;

            messageHashes[storedCount]
                    = createMessageHash(
                            messageId,
                            storedCount + 1,
                            message);

            storedCount++;

            System.out.println("Message stored.");

            break;

        default:

            System.out.println("Invalid option.");
    }
}
public static void storedMessagesMenu() {

    int choice;

    do {

        System.out.println("""
                
                === STORED MESSAGES ===
                1 Display Longest Message
                2 Search By Message ID
                3 Search By Recipient
                4 Delete By Message Hash
                5 Display Report
                6 Back
                """);

        choice = input.nextInt();
        input.nextLine();

        switch (choice) {

            case 1:

                System.out.println(
                        displayLongestMessage());

                break;

            case 2:

                System.out.println(
                        "Enter Message ID:");

                long id = input.nextLong();
                input.nextLine();

                searchByMessageID(id);

                break;

            case 3:

                System.out.println(
                        "Enter Recipient:");

                String recipient =
                        input.nextLine();

                searchByRecipient(recipient);

                break;

            case 4:

                System.out.println(
                        "Enter Message Hash:");

                String hash =
                        input.nextLine();

                deleteMessageByHash(hash);

                break;

            case 5:

                displayReport();

                break;
        }

    } while (choice != 6);
}
public static String displayLongestMessage() {

    String longest = "";

    for (int i = 0;
            i < storedCount;
            i++) {

        if (storedMessages[i] != null
                && storedMessages[i].length()
                > longest.length()) {

            longest = storedMessages[i];
        }
    }

    return longest;
}
public static void searchByMessageID(long id) {

    for (int i = 0;
            i < storedCount;
            i++) {

        if (messageIDs[i] == id) {

            System.out.println(
                    storedMessages[i]);

            return;
        }
    }

    System.out.println("Message not found.");
}
public static void searchByRecipient(String recipient) {

    boolean found = false;

    for (int i = 0; i < storedCount; i++) {

        if (recipients[i] != null
                && recipients[i].equals(recipient)) {

            System.out.println(storedMessages[i]);

            found = true;
        }
    }

    if (!found) {

        System.out.println("No messages found for this recipient.");
    }
}
public static void deleteMessageByHash(
        String hash) {

    for (int i = 0;
            i < storedCount;
            i++) {

        if (messageHashes[i] != null
                && messageHashes[i]
                        .equals(hash)) {

            System.out.println(
                    "\"" + storedMessages[i]
                    + "\" successfully deleted.");

            storedMessages[i] = null;

            messageHashes[i] = null;

            return;
        }
    }

    System.out.println("Message not found.");
}
public static void displayReport() {

    System.out.println(
            "\n=== MESSAGE REPORT ===");

    for (int i = 0;
            i < storedCount;
            i++) {

        if (storedMessages[i] != null) {

            System.out.println(
                    "\nRecipient: "
                    + recipients[i]);

            System.out.println(
                    "Message Hash: "
                    + messageHashes[i]);

            System.out.println(
                    "Message: "
                    + storedMessages[i]);
        }
    }
}
public static long generateMessageId() {

    Random random = new Random();

    return 1000000000L
            + (long) (random.nextDouble()
            * 9000000000L);
}
public static String createMessageHash(
        long messageId,
        int messageNumber,
        String message) {

    String idPart =
            String.valueOf(messageId)
            .substring(0, 2);

    String[] words =
            message.split(" ");

    String firstWord = words[0];

    String lastWord =
            words[words.length - 1];

    return (idPart + ":"
            + messageNumber + ":"
            + firstWord + ":"
            + lastWord)
            .toUpperCase();
}
}
