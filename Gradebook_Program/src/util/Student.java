/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package src.util;

public class Student {

    private String firstName;
    private String lastName;
    private String pid;
    private Grade grade;    // from the grade object

////////////////////////////////
    public Student(String firstName, String lastName, String pid, Grade grade) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }
////////////////////////////////
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
////////////////////////////////
    public String getLastName() 
    {
        return lastName;
    }
////////////////////////////////
    public void setFirstName(String fn) 
    {
        this.firstName = fn;
    }
////////////////////////////////
    public String getFirstName() 
    {
        return firstName;
    }
////////////////////////////////
    public void setPid(String PID) 
    {
        this.pid = PID;
    }
////////////////////////////////
    public String getPid() 
    {
        return this.pid;
    }
////////////////////////////////
    public String getByPid(String PID) 
    {
        if(PID.equals(this.pid)) // get this PID
        {
            return this.pid;    // return it
        }return "no student with specified PID";
    }
////////////////////////////////
    public Grade getGrade() 
    {
        return grade;
    }
////////////////////////////////
    public void setGrade(Grade grade) 
    {
        this.grade = grade;
    }
////////////////////////////////
    public String getLetter()
    {
        return this.grade.getLetterGrade();
    }
////////////////////////////////
    public String setGradeByPid(String PID, int score)
    {
        if(this.pid.equals(PID))
        {
            this.grade.setLetterGrade(score);
            this.grade.setScore(score);
            return this.grade.getLetterGrade();
        }return "no student found with specified PID";
    }
}
