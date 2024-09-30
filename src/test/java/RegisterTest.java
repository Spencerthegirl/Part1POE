/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
   package com.mycompany.st10444583part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {

    @Test
    public void testCheckUserName() {
        Register user1 = new Register("user_", "TestPassword1!");
        assertTrue(user1.checkUserName());

        Register user2 = new Register("username", "TestPassword1!");
        assertFalse(user2.checkUserName());

        Register user3 = new Register("u_r", "TestPassword1!");
        assertFalse(user3.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Register user1 = new Register("user_", "Pass1@word");
        assertTrue(user1.checkPasswordComplexity());

        Register user2 = new Register("user_", "password");
        assertFalse(user2.checkPasswordComplexity());

        Register user3 = new Register("user_", "Password1");
        assertFalse(user3.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUser() {
        Register user1 = new Register("test_", "TestPassword1!");
        assertEquals("Registration successful!", user1.registerUser());

        Register user2 = new Register("testName", "TestPassword1!");
        assertEquals("Invalid username format. Must contain an underscore (_) and be no more than 5 characters.", user2.registerUser());

        Register user3 = new Register("test_", "password");
        assertEquals("Invalid password format. Must be at least 8 characters long and contain a capital letter, a number, and a special character.", user3.registerUser());
    }

    @Test
    public void testLoginUser() {
        Register user = new Register("test_", "TestPassword1!");
        assertTrue(user.loginUser("test_", "TestPassword1!"));
       
        assertFalse(user.loginUser("test_", "wrong_password"));
        assertFalse(user.loginUser("wrong_username", "TestPassword1!"));
    }

    @Test
    public void testReturnLoginStatus() {
        Register user = new Register("test_", "TestPassword1!");
        assertEquals("Login successful!", user.returnLoginStatus(true));
        assertEquals("Login failed. Please check your username and password and try again.", user.returnLoginStatus(false));
    }
    
}