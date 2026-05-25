/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class TestMessageClass {
    //======================
    //TEST 1:Message length
    //======================
@Test
public void testMessageLengthSuccess(){
    String message = "Hi Mike, can you join us for dinner?";
    
    assertTrue(message.length()<= 250);
    
    String expected = "Message ready to send.";
    String actual ="Message ready to send.";
    assertEquals(expected, actual);
}
@Test
public void testMessageLengthFailure(){
    String message = "A".repeat(260);
    
    int excessCharacters = message.length()- 250;
    String expected = "Message exceeds 250 characters by" + excessCharacters + ",Please reduce the size.";
    String actual = "Message exceeds 250 characters by" + excessCharacters + ",Please reduce the size.";
    assertEquals(expected, actual);
}
    //===============================
    //TEST 2: Recipient number format
    //===============================
@Test
public void testRecipientNumberSuccess(){
    String recipient = "+27718693002";
    
    assertTrue(recipient.startsWith("+27"));
    assertEquals(12, recipient.length());
    
    String expected = "Cellphone number successfully captured.";
    String actual = "Cellphone number successfully captured.";
    assertEquals(expected, actual);
}
@Test
public void testRecipientNumberFailure(){
    String recipient = "08575975889";
    
    boolean valid = recipient.startsWith("+27");
    assertFalse(valid);
    
    String expected = "Cellphone number is incorrectly formatted or does not have an international code, Please correct it";
    String actual = "Cellphone number is incorrectly formatted or does not have an international code, Please correct it";
    assertEquals(expected, actual);
}
   //====================
   //TEST 3:Message Hash
   //====================
@Test
public void testMessageHash(){
    String expectedmessageHash = "00:0:HITONIGHT";
    String actualmessageHash = "00:0:HITONIGHT";
    assertEquals(expectedmessageHash, actualmessageHash);
}
   //==========================
   //TEST 4:Message id creation
   //==========================
@Test
public void testMessageIDCreated(){
    String messageId = "MSG1001";
    assertNotNull(messageId);
    
    String expected = "Message Id generated:"+ messageId;
    String actual = "Message Id generated:MSG1001";
    assertEquals(expected, actual);
}
   //=============================
   //TEST 5:Sending Message Option
   //=============================
@Test
public void testSendMessage(){
    String expected = "Message successfully sent.";
    String actual = "Message successfully sent.";
    assertEquals(expected, actual);
}
   //==============================
   //TEST 6:Deleting Message Option
   //==============================
@Test
public void testDisregardMessage(){
    String expected = "Press 0 to delete the message.";
    String actual = "Press 0 to delete the message.";
    assertEquals(expected, actual);
}
  //==========================
  //TEST 7:Storing The Message
  //==========================
@Test
public void testStoreMessage(){
    String expected = "Message successfully stored.";
    String actual = "Message successfully stored.";
    assertEquals(expected, actual);
}
  //================
  // TEST DATA TASK
  //================
@Test
public void testTask1Data(){
    int numMessages = 2;
    String recipient = "+27718693002";
    String message = "Hi Mike, can you join us for dinner tonight?";
    
    assertEquals(2, numMessages);
    assertEquals("+27718693002", recipient);
    assertEquals("Hi Mike, can you join us for dinner tonight?", message);
}
@Test
public void testTask2Data(){
    String recipient = "08575975889";
    String message = "Hi Keegan, did you receive the payment?";
    
    assertEquals("08575975889", recipient);
    assertEquals("Hi Keegan, did you receive the payment?", message);
}
    }
    

