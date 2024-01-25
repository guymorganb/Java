/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package src.util;

import java.util.*;

public class Gradebook {

	private ArrayList<Student> students;
	private int size = 0;

	////////////////////////////////////////
	public Gradebook() {
		// be sure to initialize the ArrayList here or youll get a null pointer
		// exception
		students = new ArrayList<>();
	}

	////////////////////////////////////////
	public void addStudent(Student student) {
		students.add(student);
		size++; // increment the size for tracking maybe its needed idk?
	}

	////////////////////////////////////////
	public int getSize() {
		return size;
	}

	////////////////////////////////////////
	public double calculateAvgScore() {
		double sum = 0;

		for (Student s : students) {
			sum += s.getGrade().getScore(); // score is inside Student, which is inside grade
		}
		return sum / students.size(); // divide by total students
	}

	////////////////////////////////////////
	public String calculateAvgLetter() {
		double averageScore = calculateAvgScore(); // calc avg score
		int as = (int) averageScore; // turn avg score to int

		return gradeHelper(as); // send it to the helper, conver to letter
	}

	////////////////////////////////////////
	public float calculateMedianScore() {
		// this isnt my code, this was supplied
		int i = 0;
		int n = students.size(); // get arrayList size
		int[] scores = new int[n]; // make regular array

		for (Student s : students)
			scores[i++] = s.getGrade().getScore();

		Arrays.sort(scores); // sort the array ascending

		if (n % 2 == 0)
			// divide the array in half, and take the average of the two middle values
			// if the array has an even number of elements
			return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
		else
			// otherwise array size is off, take the middle value
			return scores[n / 2];
	}

	////////////////////////////////////////
	public String calculateMedianLetter() {
		float medianLetter = calculateMedianScore(); // get the median
		int ml = (int) medianLetter; // convert to an int

		return gradeHelper(ml); // send off to be converted to letter
	}

	////////////////////////////////////////
	public float calculateMinScore() {
		float min = students.get(0).getGrade().getScore(); // set the first element to min
		for (Student s : students)
			if (s.getGrade().getScore() < min) {
				min = s.getGrade().getScore(); // score is inside Student, which is inside grade
			}
		return min;
	}
	////////////////////////////////////////
	public float calculateMaxScore() {
		float max = students.get(0).getGrade().getScore(); // set first element to max
		for (Student s : students) // loop the array of students
			if (s.getGrade().getScore() > max) { // compare eax element and update
				max = s.getGrade().getScore();
			}
		return max;
	}

	////////////////////////////////////////
	public void printAllStudents() {
		for (Student s : students)
			System.out.println(s);
	}

	////////////////////////////////////////
	public String getLetterGradeByPID(String PID) {
		for (Student s : students) {
			if (s.getByPid(PID).equals(PID))
				return s.getLetter();
		}
		return "no student found with specified PID";
	}

	////////////////////////////////////////
	public String setLetterGradeByPID(String PID, int score) {
		for (Student s : students) {
			if (s.getByPid(PID).equals(PID)) { // compare the PID's
				return s.setGradeByPid(PID, score); // set the score and return it
			}
		}
		return "no student found with specified PID...";
	}

	////////////////////////////////////////
	public String getFullNamebyPID(String PID) {
		String fullName = "";
		for (Student s : students) { // loop over the students
			if (s.getByPid(PID).equals(PID)) {
				fullName = s.getFirstName() + " " + s.getLastName(); // get first and last and concantenate
				return fullName; // return the name
			}
		}
		return "no student found with specified PID";
	}

	////////////////////////////////////////
	public String getMaxLetterGrade() {
		float maxScore = calculateMaxScore(); // calc max score
		int ms = (int) maxScore; // convert it

		return gradeHelper(ms); // send it to the helper
	}

	////////////////////////////////////////
	public String getMinLetterGrade() {
		float minScore = calculateMinScore(); // calc min score
		int ms = (int) minScore; // convert it

		return gradeHelper(ms); // send it to the helper to convert
	}

	////////////////////////////////////////
	public float getMinScore() {
		float minScore = calculateMinScore(); // calculate the min score
		return minScore; // return it
	}

	////////////////////////////////////////
	public float getMaxScore() {
		float maxScore = calculateMaxScore(); // calc max
		return maxScore; // return max
	}

	////////////////////////////////////////
	public void printScores() {
		System.out.print("----------------------------------------------------\n");
		System.out.printf("firstName\tlastName\tPID\tscore\n"); // print a tab separated list
		System.out.print("----------------------------------------------------\n"); 
		for (int i = 0; i < this.students.size(); i++) {
			Student temp = students.get(i); // get the student
			Grade tempGrade = temp.getGrade(); // get the grade inside the student
			// format and print it out
			System.out.printf("%s \t\t %s\t\t%s\t %d\n", temp.getFirstName(), temp.getLastName(), temp.getPid(),
					tempGrade.getScore());
					System.out.print("----------------------------------------------------\n"); 
		}
	}

	public void printLetterGrades() {
		System.out.print("----------------------------------------------------\n");
		System.out.printf("firstName\tlastName\tPID\tletter-grade\n"); // print a tab separated list
		System.out.print("----------------------------------------------------\n"); 
		for (int i = 0; i < this.students.size(); i++) {
			Student temp = students.get(i); // get the student
			Grade tempGrade = temp.getGrade(); // get the grade inside the student
			// format and print it out
			System.out.printf("%s \t\t %s\t\t%s\t\t %s\n", temp.getFirstName(), temp.getLastName(), temp.getPid(),tempGrade.getLetterGrade());
			System.out.print("----------------------------------------------------\n"); 
		}
	}

	////////////////////////////////////////
	private String gradeHelper(int score) { // helper function to convert calculated scores to their letter grade
											// equivalents
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
		return lg;
	}
}
// min score: Your program must calculate and print the minimum score of all
// students
// as the response to this command.
//  min letter : Your program must calculate and print the minimum letter-grade
// of all
// students as the response to this command.
//  max score: Your program must calculate and print the maximum score of all
// students
// as the response to this command.
//  max letter : Your program must calculate and print the maximum letter-grade
// of all
// students as the response to this command.
//  letter XXXXXXX : Your program must find and print the letter-grade of the
// student
// whose PID is given by the command (XXXXXXX is the PID where each X represents
// a digit).
//  name XXXXXXX : Your program must find and print the full name of the
// student
// whose PID is given by the command (XXXXXXX is the PID where each X represents
// a digit). Full name is made of first name, followed by a single white space
// and the last
// name.
// 2
//  change XXXXXXX YY : Your program must find and update the grade of the
// student
// whose PID is given by the command (XXXXXXX is the PID where each X represents
// a digit). Int this command, YY is the symbol for the new grade.
//  average score: Your program must calculate and print the average score (out
// of 100)
// of all students as the response to this command.
//  average letter : Your program must calculate and print the letter-grade of
// average score
// of all students as the response to this command.
//  median score: Your program must calculate and print the median score of all
// students
// as the response to this command.
//  median letter : Your program must calculate and print the letter-grade of
// median score
// of all students as the response to this command.
//  tab scores: Your program must print the list of all students in the form of
// a tabseparated table containing four columns with labels first name, last
// name, PID, and
// score.
//  tab letters: Your program must print the list of all students in the form
// of a tabseparated table containing four columns with labels first name, last
// name, PID, and
// letter-grades.
//  quit: Your program must stop asking for more commands and quit