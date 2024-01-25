/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package src.util;

public class Grade {

    private String letterGrade;
    private int score; // 0-100

////////////////////////////////
    public Grade(int score, String lg)
    {
        this.score = score;
        this.letterGrade = lg;
    }
////////////////////////////////
    public int getScore() 
    {
        return score;
    }
////////////////////////////////
    public void setScore(int score) 
    {
            this.score = score;
    }
////////////////////////////////
    public void setLetterGrade(int score) 
    {
        int g = score;
        String lg;
        if (g >= 95) {
            lg = "A";
        } else if (g >= 90) {
            lg = "A-";
        } else if (g >= 87) {
            lg = "B+";
        } else if (g >= 83) {
            lg = "B";
        } else if (g >= 80) {
            lg = "B-";
        } else if (g >= 77) {
            lg = "C+";
        } else if (g >= 70) {
            lg = "C";
        } else if (g >= 60) {
            lg = "D";
        } else {
            lg = "F";
        }
        this.letterGrade = lg;
    }
////////////////////////////////
    public String getLetterGrade() 
    {
        return this.letterGrade;
    }

    
}
