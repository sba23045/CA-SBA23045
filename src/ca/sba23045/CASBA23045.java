/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.sba23045;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *GITHUB: 
 * @author User
 */
public class CASBA23045 {

    /**
     * @param args the command line arguments
     */
    
public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("1. Standard Operation");
        System.out.println("2. Add Data to Status.txt");
        System.out.print("Choose an Option: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1 -> verifiedStudentsFromFile();
            case 2 -> addDataToStatusFile();
            default -> System.out.println("Invalid choice. Exist choices 1 or 2");
        }
    }
}
    //Method to verified, validating and process de user from the file:
    public static void verifiedStudentsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            while ((br.readLine()) != null) {
                String firstName = br.readLine().trim();
                String secondName = br.readLine().trim();
                int numClasses = Integer.parseInt(br.readLine().trim());
                String studentID = br.readLine().trim();
                
                if (isValidData(firstName, secondName, numClasses, studentID)) {
                    WriteToStatusFile(studentID, secondName, studentWorkload(numClasses));
                } else {
                    System.out.println("Invalid Data for Student: " + firstName + " " + secondName);
                }
            }
        } catch (Exception e) {
            System.out.println("Verified Students from the File");
        }
    }
    
    //Method to check if the validation of informatation from the data:
    public static boolean isValidData(String firstName, String secondName, int numClasses, String studentID) {
        //first name must be letters only;
        if (!firstName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Data: First name must contain letters only!");
            return false;
        }
       
        //Second name can be letters and/or numbers
        if (!secondName.matches("[a-zA-Z0-9]+")) {
            System.out.println("Invalid Data: Second name must contain letters and/or numbers only!");
            return false;
        }
        
        //number of classes must be an integer value between 1 and 8:
        if (numClasses < 1 || numClasses > 8) {
            System.out.println("Invalid Data: Number of Classes must be between 1 and 8!");
            return false;
        }
        
        //Studant number must follow the specified pattern
        if (studentID.matches("\\d{2}[a-zA-Z]{1,2}\\d+")) {
            System.out.println("Invalid Data: Invalid Student ID format!");
            return false;
        }
        return true;
    }

    //Method to write student data to the Status file:
    private static void WriteToStatusFile(String studentID, String secondName, String studentWorkload) {
         try (PrintWriter pw = new PrintWriter(new FileWriter("status.txt", true))) {
            pw.println(studentID + " - " + secondName);
            pw.println(studentWorkload);
            pw.println(); //Add empty line for better reading.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Method to determine student workload, base on the number of classes
    public static String studentWorkload(int numClasses) {
        if (numClasses == 1) {
            return "Very Light";
        } else if (numClasses == 2) {
            return "Light";
        } else if (numClasses >= 3 && numClasses <=5) {
            return "Part Time";
        } else {
            return "Full Time";
        }
    }
   
    //Method to add new student data to the Status: file:
    public static void addDataToStatusFile() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Fist Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter Second Name: ");
            String secondName = scanner.nextLine();
            
            System.out.print("Enter Number of Class: ");
            int numClasses = scanner.nextInt();
            
            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();
            
            if (isValidData(firstName, secondName, numClasses, studentID)) {
                WriteToStatusFile(studentID, secondName, studentWorkload(numClasses));
                System.out.println("Data added to status.txt sucessfully.");
            } else {
                System.out.println("Invalid data. Data not added to status.txt.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}