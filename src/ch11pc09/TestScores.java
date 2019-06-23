package ch11pc09;
import java.io.Serializable;

/**
 *
 * @author Frank
 */
public class TestScores implements Serializable {
    //fields
    private int[] scores;
    
    //constructors
    public TestScores(int number) {
        scores = new int[number];
    }
    
    //methods
    //accessors
    /**
     * This method will return the value of the array of int scores
     * @return int array of scores
     */
    public int[] getScores() {
        return scores;
    }
    
    //mutators
    /**
     * This will set the score into the scores array.  It will throw an InvalidTestScore exception 
     * 
     * @param score is the score of the exam
     * @param position is the position it will be in the array
     */
    public void setScores (int score, int position) {
        if (score > 0 && score <= 100) {
            scores[position] = score;
        }
        else {
            scores[position] = 0;
            throw new InvalidTestScore();
        }
    }
    
    /**
     * This will get the average of the scores
     * 
     * @return the average of the test scores
     */
    public double getAverage() {
        double sum = 0.0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum / scores.length;
    }
}
