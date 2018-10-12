/****************************************************************************
 *
 * Created by: Mr. Coxall
 * Modified by: Julie Nguyen
 * Created on: Sept 2016
 * This program is an example of creating an ADT with an ENUM.  
 * Modification: there is now an array that holds all the students and their
 * 		info.
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

enum GRADES {
	
	TWELVE("12"),
	ELEVEN("11"),
	TEN("10"),
	NINE("9"),
	EIGHT("8"),
	SEVEN("7"),
	SIX("6"),
	FIVE("5"),
	FOUR("4"),
	THREE("3"),
	TWO("2"),
	ONE("1"),
	SK("Senior Kindergarten"),
	JK("Junior Kindergarten");
	
	private final String grade;

    GRADES(String grade) {
        this.grade = grade;
    }
    
    public String getGrade() {
        return this.grade;
    }
    
	
}

class Student {
		
	public String _firstName;
	public String _lastName;
	public String _middleInitial;
	public String _dateOfBirth; //dd/mm/yyyy
	public GRADES _grade;
	public boolean _identified;
	
	//constructor
	public Student (String firstName, 
			        String lastName, 
			        String middleInitial, 
			        String dateOfBirth, 
			        GRADES grade, 
			        boolean identified) {
		
		this._firstName = firstName;
		this._lastName = lastName;
		this._middleInitial = middleInitial;
		this._dateOfBirth = dateOfBirth;
		this._grade = grade;
		this._identified = identified;
	}
}


public class StudentADT {
	
	public static void main(String[] args) throws IOException {
		// get student info 
		
	    boolean moreStudents = true;
		
		String firstName;
		String lastName;
		String dateOfBirth;
		String middleInitial;
		GRADES grade; 
		String gradeString;
		
		boolean identified = false;
		
		ArrayList<Student> studentsArrList = new ArrayList<Student>(); //creates array list (array list instead of array so that there is no fixed length)
		
		for (int counter = 0; moreStudents == true; counter++) {
		
		    InputStreamReader r = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(r);
		    
		    System.out.println("Enter a first name for student # " + (counter + 1) + ".");
		    firstName = br.readLine();
		    
		    System.out.println("Enter a last name for student # " + (counter + 1) + ".");
		    lastName = br.readLine();
		    
		    System.out.println("Enter a date of birth (DD/MM/YYYY) for student # " + (counter + 1) + ".");
		    dateOfBirth = br.readLine();
		    
		    System.out.println("Enter a middle initial for student # " + (counter + 1) + ".");
		    middleInitial = br.readLine();
		    
		    System.out.println("Enter a grade (as plain text: JK-TWELVE) for student # " + (counter + 1) + ".");
		    gradeString = br.readLine();
		    grade = GRADES.valueOf(gradeString.toUpperCase());
		    
		    
		    System.out.println("Is student # " + (counter + 1) + " identified? Y/N");
		    
		    if (br.readLine()== "Y") {
		    		identified = true;
		    }
		    
		    Student currentStudent = new Student(firstName, lastName, dateOfBirth, middleInitial, grade, identified);
		    
		    studentsArrList.add(currentStudent); //append new student to array list
			
		    System.out.print("Current Students: \n");
		    
		    for(int nextStudent = 0; nextStudent < studentsArrList.size(); nextStudent ++) {
				System.out.print(studentsArrList.get(nextStudent)._firstName + ", " + studentsArrList.get(nextStudent)._grade +"\n");
				}
		    System.out.print("\n\n");
		    
		    System.out.println("Exit program? ");
		    if(br.readLine()== "Y") {
		    	break;
		    }
		    
		}
	}
	
}
