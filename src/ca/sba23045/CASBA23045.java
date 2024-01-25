/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.sba23045;

import java.util.Scanner;

/**
 *
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
            case 1 : verifiedStudentFromFile();
            case 2 : addDataToStatusFile();
            default : System.out.println ("Invalid choice. Exist choices 1 or 2");
        }
    }
                
            
    }

    private static void verifiedStudentFromFile() {
        try (BufferedReader br = new BufferedReader (new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String firstName = line.trim();
                String secondName = line.trim();
                int numClasses = Integer.parseInt(br.readLine().trim());
                String studentID = br.readLine().trim();
                
            }
        }
        }

    private static void addDataToStatusFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
 

