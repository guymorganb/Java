/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import src.util.*;

public class Main {
    // method to sanatize inputs
    public static boolean sanitizeInput(String userInput) throws IOException {
        String regexString = "^[A-Za-z]+\\s[A-Za-z]*(\\.[A-Za-z]*)*\\s[0-9]+\\s(100|[1-9]?[0-9])$"; // used //
                                                                                                    // 'https://regex101.com/'
        /*
         * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         * ^[A-Za-z]+: Matches the first name, which should consist of one or more
         * letters.
         * \\s: A space character.
         * [A-Za-z]+: Matches the last name, which should also consist of one or more
         * letters.
         * \\s: Another space character.
         * [0-9]+: Matches a numeric ID of one or more digits.
         * \\s: Another space character.
         * (100|[1-9]?[0-9])$: Matches a numeric grade, which can be 100, or any number
         * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         */
        if (userInput.equalsIgnoreCase("done")) {
            return true;
        } else if (!userInput.toLowerCase().matches(regexString)) { // regex to sanitize inuput format
            throw new IllegalArgumentException(
                    "\033[31m" + // ANSI escape code for red text see: https://gist.github.com/kamito/704813
                            "Invalid input please ensure to follow the specified formatting rules" +
                            "\033[0m" + "\033[31m"
                            + " | firstName lastName PID grade \"note: PID & grade are integers\"" + "\033[0m"); // ANSI
                                                                                                                 // reset
                                                                                                                 // code
                                                                                                                 // to
                                                                                                                 // return
                                                                                                                 // to
                                                                                                                 // default
                                                                                                                 // after
                                                                                                                 // the
                                                                                                                 // message);
        } else {
            return true;
        }
    }

    // split up the incoming string, put in array list
    public static ArrayList<ArrayList<String>> parseArrayHelper(String userInput,
            ArrayList<ArrayList<String>> arrayToAddTo) {
        String[] temp = userInput.split("\\s+"); // split the string across its white spaces, return an array of split
                                                 // elements
        ArrayList<String> ud = new ArrayList<>(); // create an arraylist we will store stuff in
        Map<String, String> studentInfo = new HashMap<>(); // set up a hashmap so its easier to sort this stuff

        for (int i = 0; i < temp.length; i++) // loop over the array we split up from the user input string
        {
            switch (i) { // put all the values into a hash map with keys, so we can easily grab them
                         // later from inside the objects we'll create
                case 0:
                    studentInfo.put("firstName", temp[i]); // set firstName : <user first name>
                    break;
                case 1:
                    studentInfo.put("lastName", temp[i]); // // set lastName : <user last name>
                    break;
                case 2:
                    studentInfo.put("id", temp[i]); // set id : <user PID>
                    break;
                case 3:
                    studentInfo.put("grade", temp[i]); // set grade : <user grade>
                    int g = Integer.parseInt(studentInfo.get("grade"));
                    // set the letter grade based on the points
                    if (g >= 95) {
                        studentInfo.put("letterGrade", "A");
                    } else if (g >= 90) {
                        studentInfo.put("letterGrade", "A-");
                    } else if (g >= 87) {
                        studentInfo.put("letterGrade", "B+");
                    } else if (g >= 83) {
                        studentInfo.put("letterGrade", "B");
                    } else if (g >= 80) {
                        studentInfo.put("letterGrade", "B-");
                    } else if (g >= 77) {
                        studentInfo.put("letterGrade", "C+");
                    } else if (g >= 70) {
                        studentInfo.put("letterGrade", "C");
                    } else if (g >= 60) {
                        studentInfo.put("letterGrade", "D");
                    } else {
                        studentInfo.put("letterGrade", "F");
                    }
                    break;
                default:
                    break;
            }
        }
        // Concatenate all values back into one string
        userInput = "";
        for (Map.Entry<String, String> hashMapEntry : studentInfo.entrySet()) {
            userInput += hashMapEntry.getValue() + " ";
        }

        userInput = userInput.trim(); // trim the strings white space
        ud.add(userInput); // add the string to the arraylist
        arrayToAddTo.add(ud); // add the arraylist to the arraylist of arraylists

        return arrayToAddTo;
    }

    // grab the users input from System.in
    public static void getInput(Scanner scnr, ArrayList<ArrayList<String>> userData, int index) throws IOException {
        // get some input from the user
        System.out.print(
                "Please enter the information of the next student using the same format.\n If there is no more students, please enter the keyword “DONE”.\n “firstName lastName PID grade”.\n Press Enter when you are done.\n");
        String tempStr = scnr.nextLine();
        System.out.println(); // print a line for space
        // now clean up the inputs
        if (sanitizeInput(tempStr)) {
            // check tempString == "done" to move onto the next phase
            if (tempStr.equalsIgnoreCase("done")) {
                // enter command handling phase | calculate statistics from user input
                commandHandling(scnr, userData, index);
            } else {
                // clean up the string in case I missed something
                tempStr = tempStr.toLowerCase(); // convert the string to lowercase
                tempStr = tempStr.trim(); // trim any whitespace
                userData = parseArrayHelper(tempStr, userData); // parse incoming data
                getInput(scnr, userData, ++index); // call getInput again and incrment index
            }
        }
    }

    public static void commandHandling(Scanner scnr, ArrayList<ArrayList<String>> userData, int index) {
        Gradebook myGradebook = new Gradebook();
        boolean toggle = true;
        int i = 0;
        while (i <= index) {
            // break down the first arrayList
            ArrayList<String> ud = userData.get(i);
            // get the element from the arrayList and split up the string on its spaces
            String[] temp = ud.get(0).split("\\s+");
            // extract all the parts
            String firstName = temp[0];
            String lastName = temp[1];
            int numericGrade = Integer.parseInt(temp[2]); // use wrapper class to convert the string to an int
            String letterGrade = temp[3];
            String PID = temp[4];
            // start by creating a grade object and setting it
            Grade dynamicGrade = new Grade(numericGrade, letterGrade);
            // create the student, and place the grade along with the student
            Student dynamicStudent = new Student(firstName, lastName, PID, dynamicGrade);
            // place the student in the gradebook
            myGradebook.addStudent(dynamicStudent);
            // increment i
            ++i;
        }

        myGradebook.printAllStudents(); // print students for convenience to view PIDs etc.
        while (toggle) {
            System.out.print("\033[31m" +
                    "Please enter a new command | replace <PID> with actual PID & do not include the \"-\" before your input: "
                    + "\033[0m" +
                    "\033[32m" + "\n Options:\"\033[0m"
                    + "\n -min score\n -min letter\n -max score\n -max letter\n -printGrade\n -PrintFullName\n -updateLetterGrade\n -average score\n -average letter\n -median score\n -median letter\n -score table\n -grade table\n QUIT\n");

            System.out.println();
            String userCommand = scnr.nextLine();

            switch (userCommand) {
                case "min score":
                    System.out.println(myGradebook.getMinScore());
                    break;
                case "min letter":
                    System.out.println(myGradebook.getMinLetterGrade());
                    break;
                case "max score":
                    System.out.println(myGradebook.getMaxScore());
                    break;
                case "max letter":
                    System.out.println(myGradebook.getMaxLetterGrade());
                    break;
                case "printGrade":
                    System.out.println("Please enter the PID");
                    String tempCmd = scnr.nextLine();
                    System.out.println(myGradebook.getLetterGradeByPID(tempCmd));
                    break;
                case "PrintFullName":
                    System.out.println("Please enter the PID");
                    String tempCmd2 = scnr.nextLine();
                    System.out.println(myGradebook.getFullNamebyPID(tempCmd2));
                    break;
                case "updateLetterGrade":
                    System.out.println("Please enter the <PID> a space, then the integer grade");
                    String tempCmd4 = scnr.nextLine();
                    String tempCmd3[] = tempCmd4.split("\\s+");
                    System.out.println(myGradebook.setLetterGradeByPID(tempCmd3[0], Integer.valueOf(tempCmd3[1])));
                    break;
                case "average score":
                    System.out.println(myGradebook.calculateAvgScore());
                    break;
                case "average letter":
                    System.out.println(myGradebook.calculateAvgLetter());
                    break;
                case "median score":
                    System.out.println(myGradebook.calculateMedianScore());
                    break;
                case "median letter":
                    System.out.println(myGradebook.calculateMedianLetter());
                    break;
                case "score table":
                    myGradebook.printScores();
                    break;
                case "grade table":
                    myGradebook.printLetterGrades();
                    break;
                case "QUIT":
                    toggle = false;
                    break;
                default:
                    System.out.println(
                            "\033[31m" + // ANSI escape code for red text see: https://gist.github.com/kamito/704813
                                    "Invalid input please ensure to follow the specified formatting rules" +
                                    "\033[0m" + "\033[31m"
                                    + " replace <PID> with actual PID & do not include the \"-\" before your input or type quit to end (case sensitive)"
                                    + "\033[0m");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        // get user input from System.in
        Scanner scnr = new Scanner(System.in);
        boolean toggle = false;
        int index = -1;
        ArrayList<ArrayList<String>> userArrays = new ArrayList<>();

        while (!toggle) {
            System.out.print(
                    "Welcome to my grade book!\n Please enter the information of the first student using the following format:\n “firstName lastName PID grade”.\n Press Enter when you are done.\n");
            String userInput = scnr.nextLine(); // take input for firstName lastName PID grade
            System.out.println();
            toggle = sanitizeInput(userInput); // check if input is valid

            if (toggle) {
                userInput = userInput.toLowerCase(); // convert the string to lowercase
                userInput = userInput.trim();
                userArrays = parseArrayHelper(userInput, userArrays);
                // send the userArrays off to get more input
                getInput(scnr, userArrays, ++index);
            }
        }
        scnr.close();

    }

}