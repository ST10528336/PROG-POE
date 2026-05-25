/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.project.LoginClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class TestLoginClass {
   LoginClass log = new LoginClass();
   //Testing the userName
   @Test
   public void TestuserNameCorrectFormatted(){
    boolean result = log.checkUsername("ky1_1");
    assertTrue(result);
   }
    @Test
    public void TestuserNameIncorrectFormatted(){
        boolean result = log.checkUsername("kyle!!!!!!");
        assertFalse(result);
    }
    //Testing the password of the user
   @Test
   public void TestpassWordCorrect(){
       boolean result = log.checkPassword("Ch&&sec@ke99!");
       assertTrue(result);
   }
   @Test
   public void TestpassWordIncorrect(){
       boolean result = log.checkPassword("password");
       assertFalse(result);
   }
   //Testing if cellphone number is entered correctly
   @Test
   public void TestcellPhonenumberCorrect(){
     boolean result = log.checkCellPhoneNumber("+27838968976");
     assertTrue(result);
   }
   @Test
   public void TestcellPhonenumberIncorrect(){
       boolean result = log.checkCellPhoneNumber("08966553");
       assertFalse(result);
   }
   @Test
   public void TestLoginSuccessful(){
       boolean result = log.loginUser("ky1_1", "Ch&&sec@ke99!");
       assertTrue(result);
   }
   @Test
   public void TestLoginFailed(){
       boolean result = log.loginUser("wrongUser", "wrongPass");
       assertFalse(result);
   }
   @Test
   public void TestUsernameSuccessMessage(){
       String expected = "Welcome user first name, user last name it is great to see you.";
       String actual = log.registerUser("ky1_1", "Ch&&sec@ke99!", "+27838968976");
       assertEquals(expected, actual);
   }
   @Test
   public void TestUsernameFailureMessage(){
       String expected = "Username is not correctly formatted;Please ensure that your username contains an underscore and is no more than five characters in length.";
       String actual = log.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
       assertEquals(expected, actual);
   }
   @Test
   public void TestPasswordFailureMessage(){
       String expected = "Password is not correctly formatted;Please ensure that the password contains at least eight characters,a capital letter,a number,and a special character.";
       String actual = log.registerUser("ky1_1","password", "+27838968976");
       assertEquals(expected, actual);
   }
   @Test
   public void TestCellphoneFailureMessage(){
       String expected = "Cell number is incorrectly formatted or does not contain an international code;please correct the number and try again.";
       String actual = log.registerUser("ky1_1", "Ch&&sec@ke99!", "08966553");
       assertEquals(expected, actual);
   }
}