/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class ProjectTest {
    
    public ProjectTest() {
    }

    @Test
    public void testGenerateMessageId() {

        long result = Project.generateMessageId();

        assertEquals(10, String.valueOf(result).length());
    }

    @Test
    public void testCreateMessageHash() {

        String result = Project.createMessageHash( 1234567890L, 1, "Did you get the cake");
        assertEquals( "12:1:DID:CAKE",result);
    }

    @Test
    public void testDisplayLongestMessage() {

        // Arrange
        Project.storedMessages[0] = "Hi";
        Project.storedMessages[1] = "Where are you? You are late! I have asked you to be on time.";
        Project.storedCount = 2;

        // Act
        String result = Project.displayLongestMessage();
        // Assert
        assertEquals("Where are you? You are late! I have asked you to be on time.",result);
    }

    @Test
    public void testStoredMessagesArray() {

        Project.storedMessages[0] ="Did you get the cake?";
        assertEquals("Did you get the cake?",Project.storedMessages[0]);
    }

    @Test
    public void testMessageIDArray() {

        Project.messageIDs[0] =1234567890L;
        assertEquals( 1234567890L,Project.messageIDs[0]);
    }
}

