package MiniProject.Service;

import java.sql.*;

public class InternshipService {
 private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 private static final String URL = "jdbc:mysql://localhost:3306/placements";
 private static final String USER = "root";
 private static final String PASSWORD = "Gowtham@1729";

 private Connection conn;
 private Statement stmt;
 private ResultSet rs;

 public InternshipService()  throws SQLException {
     try {
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
 }

 public void displayInternships() {
     String sql = "SELECT * FROM internships";
     try {
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         System.out.println("--------------------------------");
         System.out.println("|     Available Internships:   |");
         System.out.println("--------------------------------");
        
         while (rs.next()) {
             int id = rs.getInt("id");
             String role = rs.getString("role");
             System.out.printf("| %-5s | %-20s |",id,role);
             System.out.println();
         }
         System.out.println("--------------------------------");
         System.out.println();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
 
 public void viewinterns(String name) {
	
     String sql = "SELECT * FROM interns where username=?";
     try {
    	 PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, name);
         rs = pstmt.executeQuery();
        
         while (rs.next()) {
             String username = rs.getString("username");
             int internshipid = rs.getInt("internshipid");
             System.out.println();
             System.out.print(internshipid);
          
         }
         System.out.println();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void displayInternships(int internshipId) {
     String sql = "SELECT * FROM internships WHERE id = ?";
     try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, internshipId);
         rs = pstmt.executeQuery();

         if (rs.next()) {
             int id = rs.getInt("id");
             String company = rs.getString("company");
             int duration = rs.getInt("duration");
             String role = rs.getString("role");
             String description = rs.getString("description");
             System.out.println();
             System.out.println("Detailed Description of Internship (ID: " + id + "):");
             
             System.out.println("-----------------------------------------------");
           
             System.out.printf("| %-20s | %-20s |","Company " , company);
             System.out.println();
             System.out.printf("| %-20s | %-1s  %-17s |","Duration " , duration , " months");
             
             System.out.println();
             System.out.printf("| %-20s | %-20s |","Role " , role);
                       
             System.out.println();
             System.out.println("-----------------------------------------------");
             System.out.println();

         } else {
             System.out.println("No internship found with ID: " + internshipId);
         }
         System.out.println();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void addCandidate(int userId, String name, String email, int rollno, int batch, float cgpa, int internshipId) {
     String sql = "INSERT INTO interns (userid, username, email, rollno, batch, cgpa, internshipId) VALUES (?, ?, ?, ?, ?, ?, ?)";
     try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, userId);
         pstmt.setString(2, name);
         pstmt.setString(3, email);
         pstmt.setInt(4, rollno);
         pstmt.setInt(5, batch);
         pstmt.setFloat(6, cgpa);
         pstmt.setInt(7, internshipId);
         pstmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
 
 public void addCandidate(int userId, int internshipId) {
     String sql = "INSERT INTO internid (userid,internshipId) VALUES (?,?)";
     try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, userId);
         pstmt.setInt(2, internshipId);
         pstmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }



 public void close() {
     try {
         if (rs != null) {
             rs.close();
         }
         if (stmt != null) {
             stmt.close();
         }
         if (conn != null) {
             conn.close();
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}
