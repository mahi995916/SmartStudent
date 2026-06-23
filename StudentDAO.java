package Main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
	

    public void addStudent(Student student) {
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "INSERT INTO students(name,roll_no,department,email,phone,marks) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getRollNo());
            ps.setString(3, student.getDepartment());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhone());
            ps.setDouble(6, student.getMarks());
           int rows= ps.executeUpdate();
           if(rows>0) {
            System.out.println("Student Updated Successfully");
           }else {
        	   System.out.println("Student Not Found");   
           }

            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void updateStudent(String rollNo, String name,
            String department, String email,
            String phone, double marks) {

        try {

            Connection con = DatabaseConnection.getConnection();

            String sql = "UPDATE students SET name=?, department=?, email=?, phone=?, marks=? WHERE roll_no=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setDouble(5, marks);
            ps.setString(6, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully");
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

	public void viewStudents() {
		    try {

		        Connection con = DatabaseConnection.getConnection();

		        String sql = "SELECT * FROM students";

		        PreparedStatement ps = con.prepareStatement(sql);

		        ResultSet rs = ps.executeQuery();

		        System.out.println("---------------------------------------------------------------");
		        System.out.printf("%-5s %-15s %-10s %-10s %-20s %-15s %-8s%n",
		                "ID", "Name", "RollNo", "Dept", "Email", "Phone", "Marks");
		        System.out.println("---------------------------------------------------------------");

		        while (rs.next()) {

		            System.out.printf("%-5d %-15s %-10s %-10s %-20s %-15s %-8.2f%n",
		                    rs.getInt("id"),
		                    rs.getString("name"),
		                    rs.getString("roll_no"),
		                    rs.getString("department"),
		                    rs.getString("email"),
		                    rs.getString("phone"),
		                    rs.getDouble("marks"));
		        }
		        con.close();

		    } catch (Exception e) {

		        System.out.println(e);

		    }

		}
	public void deleteStudent(String rollNo) {

	    try {

	        Connection con = DatabaseConnection.getConnection();

	        String sql = "DELETE FROM students WHERE roll_no=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, rollNo);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Student Deleted Successfully");
	        } else {
	            System.out.println("Student Not Found");
	        }

	        con.close();

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	public void searchStudentByRollNo(String rollNo) {

	    try {

	        Connection con = DatabaseConnection.getConnection();

	        String sql = "SELECT * FROM students WHERE roll_no=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, rollNo);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            System.out.println("\n===== Student Details =====");

	            System.out.println("ID         : " + rs.getInt("id"));
	            System.out.println("Name       : " + rs.getString("name"));
	            System.out.println("Roll No    : " + rs.getString("roll_no"));
	            System.out.println("Department : " + rs.getString("department"));
	            System.out.println("Email      : " + rs.getString("email"));
	            System.out.println("Phone      : " + rs.getString("phone"));
	            System.out.println("Marks      : " + rs.getDouble("marks"));

	        } else {

	            System.out.println("Student Not Found");

	        }

	        con.close();

	    } catch (Exception e) {

	        System.out.println(e);

	    }

	}
	public void searchByDepartment(String department) {

	    try {

	        Connection con = DatabaseConnection.getConnection();

	        String sql = "SELECT * FROM students WHERE department = ?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, department);

	        ResultSet rs = ps.executeQuery();

	        boolean found = false;

	        System.out.println("--------------------------------------------------------------------------");
	        System.out.printf("%-5s %-15s %-10s %-10s %-25s %-15s %-8s%n",
	                "ID", "Name", "RollNo", "Dept", "Email", "Phone", "Marks");
	        System.out.println("--------------------------------------------------------------------------");

	        while (rs.next()) {

	            found = true;

	            System.out.printf("%-5d %-15s %-10s %-10s %-25s %-15s %-8.2f%n",
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("roll_no"),
	                    rs.getString("department"),
	                    rs.getString("email"),
	                    rs.getString("phone"),
	                    rs.getDouble("marks"));
	        }

	        if (!found) {
	            System.out.println("No students found in this department.");
	        }

	        con.close();

	    } catch (Exception e) {

	        System.out.println(e);

	    }

	}
	public void searchByMarks(double minMarks) {

	    try {

	        Connection con = DatabaseConnection.getConnection();

	        String sql = "SELECT * FROM students WHERE marks >= ?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setDouble(1, minMarks);

	        ResultSet rs = ps.executeQuery();

	        boolean found = false;

	        System.out.println("------------------------------------------------------------------------------------");
	        System.out.printf("%-5s %-15s %-10s %-10s %-25s %-15s %-8s%n",
	                "ID", "Name", "RollNo", "Dept", "Email", "Phone", "Marks");
	        System.out.println("------------------------------------------------------------------------------------");

	        while (rs.next()) {

	            found = true;

	            System.out.printf("%-5d %-15s %-10s %-10s %-25s %-15s %-8.2f%n",
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("roll_no"),
	                    rs.getString("department"),
	                    rs.getString("email"),
	                    rs.getString("phone"),
	                    rs.getDouble("marks"));
	        }

	        if (!found) {
	            System.out.println("No students found with marks greater than or equal to " + minMarks);
	        }

	        con.close();

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
		
	}

	