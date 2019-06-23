package ch11pc09;

/**
 *
 * @author Frank
 */
public class InvalidTestScore extends IllegalArgumentException {
    
    public InvalidTestScore() {
        super("Invalid test score.  Score must be between 0 and 100.");
    }
    
    public InvalidTestScore(String message) {
        super(message);
    }
    
    public InvalidTestScore(Throwable throwable) {
        super(throwable);
    }
}
