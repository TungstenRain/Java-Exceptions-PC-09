package ch11pc09;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author frank.olson
 * date 11/30/2017
 * purpose: to serialize an object
 */
public class Ch11pc09 {

    public static void main(String[] args) {
        // variables
        int students, tests, score;
        String outputFileName;
        boolean fileFound;
        
        //instantiate Scanner class keyboard
        Scanner keyboard = new Scanner(System.in);
        
        //request user to input scores
        System.out.print("Please enter the number of students taking exams. ");
        students = keyboard.nextInt();        
        System.out.print("Please enter the number of tests per student. ");
        tests = keyboard.nextInt();
                
        //instantiate the TestScores class
        TestScores[] testScores = new TestScores[students];
        
        //instantiate each class within the array
        for (int i = 0; i < testScores.length; i++) {
            testScores[i] = new TestScores(tests);
        }
        
        //request scores from user
        for (int i = 0; i < testScores.length; i++) {
            System.out.println("Exams for student #" + (i + 1) + ".");
            
            for (int j = 0; j < 3; j++){
                System.out.print("Please enter the score for student #" + (i +1) + ", exam #" + (j + 1) + ". ");
                score = keyboard.nextInt();
                try {
                    testScores[i].setScores(score, (j));
                }
                catch (InvalidTestScore ex) {
                    System.out.println(ex.getMessage());
                    j--;
                }
                catch (NullPointerException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //display the average for the scores
            System.out.println("The average of the test scores is: " + testScores[i].getAverage() + ".");
        }

        //Serialize class TestScores
        
        do {
            try {
                System.out.print("Please enter the file name to serialize the test scores to: ");
                outputFileName = keyboard.next();
                
                //instantiate the stream objects
                FileOutputStream outputStream = new FileOutputStream(outputFileName);
                ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);
                
                //write serialized objects to file
                for (int i = 0; i < testScores.length; i++) {
                    objectOutputFile.writeObject(testScores[i]);
                }
                
                //close the file
                objectOutputFile.close();
                
                System.out.println("The serialized objects were written to the " + outputFileName + " file.");
                fileFound = true;
            }
            catch (FileNotFoundException ex) {
                System.out.println("Error.  File not found.");
                System.out.println(ex.getMessage());
                fileFound = false;
            }
            catch (IOException ex) {
                System.out.println("Error.");
                System.out.println(ex.getMessage());
                fileFound = true;
            }

        } while (!fileFound);
        
    }
    
}
