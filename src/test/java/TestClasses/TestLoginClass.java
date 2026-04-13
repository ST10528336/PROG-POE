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
   public void TestuserNameCorrect()
   {
    assertEquals(true , log.checkUsername("kyl_1"));
       
   }
    @Test
    public void TestuserNameIncorrect()
    {
        assertEquals(false , log.checkUsername("kyle!!!!!"));
    }
    //Testing the password of the user
   @Test
   public void TestpassWordCorrect()
   {
       assertEquals(true , log.checkPassword("Ch&&sec@ke99!"));
   }
   @Test
   public void TestpassWordIncorrect()
   {
       assertEquals(false , log.checkPassword("password"));
   }
   //Testing if cellphone number is entered correctly
   @Test
   public void TestcellPhonenumberCorrect()
   {
     assertEquals(true , log.checkCellPhoneNumber("+27838968976"));  
   }
   @Test
   public void TestcellPhonenumberIncorrect()
   {
       assertEquals(false , log.checkCellPhoneNumber("08966553"));
   }
}