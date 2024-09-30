/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10444583part1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class ST10444583Part1 {

    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
        System.out.println("\tWelcome To Registration System!");

        // Get user's name and surname
        System.out.print("\tEnter Name: ");
        String name = input.next();
        
        System.out.print("\tEnter Surname: ");
        String surname = input.next();

        String username = "";
        String password = "";
        boolean isRegistered = false;

        // Loop to get valid username and password for registration
        while (!isRegistered) {
            System.out.print("\nEnter a username (5 or fewer characters, containing an underscore): ");
            username = input.next();
            
            System.out.print("Enter a password (8 or more characters, containing a digit, capital letter, and special character): ");
            password = input.next();

            // Create a new Login object with the entered credentials
            Register user = new Register(username, password);
            String registrationStatus = user.registerUser();

            // Check if registration was successful
            if (registrationStatus.contains("successful")) {
                isRegistered = true; // Exit loop if registration is successful
                System.out.println("\n" + registrationStatus);
            } else {
                System.out.println("\nRegistration failed. " + registrationStatus);
            }
        }

        boolean isLoggedIn = false;
        // Create user object with valid credentials for login
        Register user = new Register(username, password);

        // Loop for login attempts
        while (!isLoggedIn) {
            System.out.print("Enter your username to login: ");
            String inputUsername = input.next();
            System.out.print("Enter your password: ");
            String inputPassword = input.next();

            // Check login status
            boolean loginStatus = user.loginUser(inputUsername, inputPassword);
            System.out.println(user.returnLoginStatus(loginStatus));

            // Set login status based on credentials
            if (loginStatus) {
                isLoggedIn = true;
            } else {
                System.out.println("Please try again.");
            }
        }

        // Welcome message after successful login
        System.out.println("Welcome " + name + " " + surname + ", it is great to see you again!");
    }
}