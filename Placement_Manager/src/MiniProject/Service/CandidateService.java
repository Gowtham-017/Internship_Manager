package MiniProject.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class CandidateService extends InternshipService {

    public CandidateService() throws SQLException  {
        super(); 
    }
    public void applyForInternship() throws SQLException {
        System.out.println();
		System.out.println("       ************** Internship Placement Management System **************");
		System.out.println();

		displayInternships();

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the internship ID you want to apply for: ");
		
		
		int internshipId = scanner.nextInt();
		displayInternships(internshipId);
		System.out.println();

		System.out.print("Do you want to continue applying for the Internship? (Y/N)");
		char yesno = scanner.next().charAt(0);
		if (yesno == 'Y' || yesno == 'y') {
		    System.out.println();
		    System.out.println("***************************************************");
		    System.out.println("Fill Out the Details to Apply for the Internship:");
		    System.out.println();
		    System.out.print("Enter your Id: ");
		    int userId = scanner.nextInt();
		    System.out.print("Enter your name: ");
		    String name = scanner.next();
		    System.out.print("Enter your email: ");
		    String email = scanner.next();
		    System.out.print("Enter your rollno: ");
		    int rollno = scanner.nextInt();
		    System.out.print("Enter your batch: ");
		    int batch = scanner.nextInt();
		    System.out.print("Enter your cgpa: ");
		    float cgpa = scanner.nextFloat();

		    addCandidate(userId, name, email, rollno, batch, cgpa, internshipId);
		    addCandidate(userId, internshipId);
		    System.out.println();
		    System.out.println("***************************************************");
		    System.out.println();
		   
		    System.out.println("Hey "+name);
		     System.out.println("Internships you have applied for:");
		  
		     viewinterns(name);
		     System.out.println("---------------------------------------------");
		     System.out.println("Application Successful");
			    System.out.println("We will reach out to you soon with further details...");
		} else if (yesno == 'N' || yesno == 'n') {
		    System.out.println("Search for other available internships");
		} else {
		    System.out.println();
		}
		scanner.close();
    }
   
}
