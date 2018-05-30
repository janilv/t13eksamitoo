package studentdatabaseapp;
import java.util.Scanner;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 40;
	private static int id = 1000;
	
	// Konstruktor, mis laseb õpilasel sisetada nime ja aasta
	public Student(){
		Scanner in = new Scanner(System.in);
		System.out.println("Siseta õpilase eesnimi: ");
		this.firstName = in.nextLine();
		
		System.out.println("Siseta õpilase perenimi: ");
		this.lastName = in.nextLine();
		
		System.out.println("Siseta õpilase kursus: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
		
	}
	
	// genereerime õpilasele unikaalse ID
	private void setStudentID(){
		//õpeaasta + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	// registeeri kursustele
	public void enroll(){
		//dd
		do{
			System.out.print("Sisesta kursus, kuhu soovid registeerida (Q, et lõpetada): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")){
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else {
				break;
			}
		} while( 1 != 0);
			
	}
	
	// vaata kontojääki
	public void viewBalance(){
		System.out.println("Sinu õppemaks on: €" + tuitionBalance);
	}
	// maksa õppemaksu
	public void payTuition(){
		viewBalance();
		System.out.print("Sisesta oma makstav summa: €");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Täname maksmast summat väärtusega €" + payment);
		viewBalance();
	}
	// näita infot
	public String toString(){
		return "Nimi: " + firstName + " " + lastName +
				"\nÕppeaasta: " + gradeYear +
				"\nÕpilase kood: " + studentID +
				"\nVõetud ained:" + courses +
				"\nÕppevõlg: €" + tuitionBalance;
	}
        
        public void writeResult() {
        
        File file = new File ("");
        PrintWriter printWriter = null;
        
        try {   
            printWriter = new PrintWriter (new FileWriter("Students.txt", true));
            printWriter.println ("Õpilase nimi: " + firstName + " " + lastName+
				"\n Õppeaasta: " + gradeYear +
				"\n Õpilase kood: " + studentID +
				"\n Võetud ained:" + courses +
				"\n Õppevõlg: €" + tuitionBalance);

        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        printWriter.close ();
    }
}
