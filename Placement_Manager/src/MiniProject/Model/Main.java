//package MiniProject.Model;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import MiniProject.Service.InternshipService;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//        	
//            InternshipService is = new InternshipService();
////            Internship internship = new Internship();
//
//            System.out.println();
//            System.out.println("************** Internship Placement Management System **************");
//            System.out.println();
//
//            is.displayInternships();
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter the internship ID you want to apply for: ");
//            int internshipId = scanner.nextInt();
//            is.displayInternships(internshipId);
//            System.out.println();
//
//            System.out.print("Do you want to continue applying for the Internship? (Y/N)");
//            char yesno = scanner.next().charAt(0);
//            if (yesno == 'Y' || yesno == 'y') {
//                System.out.println();
//                System.out.print("Enter your Id: ");
//                int userId = scanner.nextInt();
//                System.out.print("Enter your name: ");
//                String name = scanner.next();
//                System.out.print("Enter your email: ");
//                String email = scanner.next();
//                System.out.print("Enter your rollno: ");
//                int rollno = scanner.nextInt();
//                System.out.print("Enter your batch: ");
//                int batch = scanner.nextInt();
//                System.out.print("Enter your cgpa: ");
//                float cgpa = scanner.nextFloat();
//              
//                is.addCandidate(userId, name, email, rollno, batch, cgpa, internshipId);
//                is.addCandidate(userId,internshipId);
//                System.out.println("---------------------------------------");
//                System.out.println("Application Successful");
//                System.out.println("We will reach out to you soon with further details...");
//            } else if (yesno == 'N' || yesno == 'n') {
//                System.out.println("Search for other available internships");
//            } else {
//                System.out.println();
//            }
//
//            scanner.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}


package MiniProject.Model;

import java.sql.SQLException;
import MiniProject.Service.CandidateService;

public class Main {
    public static void main(String[] args) {
        try {
            CandidateService candidateService = new CandidateService();
            candidateService.applyForInternship();
            candidateService.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
