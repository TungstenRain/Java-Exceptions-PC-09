package ch11pc09;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author frank.olson
 */
public class ch11pc09ds {
    public static void main(String[] args) {
        //variables
        String fileName;
        int students, exams;
        
        //instantiate Scanner class keyboard
        Scanner keyboard = new Scanner(System.in);
        
        //Request info from user
        System.out.print("Please enter the name of the file to deserialize: ");
        fileName = keyboard.nextLine();
        System.out.print("Please enter the number of students that took the exam. ");
        students = keyboard.nextInt();
        System.out.print("Please enter the number of exams taken per student. ");
        exams = keyboard.nextInt();
                
        try {
            //instantiate the stream objects
            FileInputStream inStream = new FileInputStream(fileName);
            ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
            
            //instantiate the TestScores class
            TestScores[] testScores = new TestScores[students];

            //instantiate each class within the array
            for (int i = 0; i < testScores.length; i++) {
                testScores[i] = new TestScores(exams);
            }
            
            //read the serialized object from the file
            for (int i = 0; i < testScores.length; i++) {
                testScores[i] = (TestScores) objectInputFile.readObject();
            }
            
            //close the file
            objectInputFile.close();
            
            //Display the results to the user
            for (int i = 0; i < testScores.length; i++) {
                System.out.println("The average score for student " + (i + 1) + " is " + testScores[i].getAverage());
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("IOException thrown.");
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Class not found.");
            System.out.println(ex.getMessage());
        }
        
    }
}
