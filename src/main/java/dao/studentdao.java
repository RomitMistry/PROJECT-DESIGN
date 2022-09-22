package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import dbconnection.studentconn;

import model.modelstudentreg;

public class studentdao {
	public static void insertstudent(modelstudentreg s) {
		try {
			Connection conn = studentconn.createConnection();
			String sql = "insert into student_regs (fname,lname,email,phone,gender,password) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getfname());
			pst.setString(2, s.getlname());
			pst.setString(3, s.getemail());
			pst.setLong(4, s.getphone());
			pst.setString(5, s.getgender());
			pst.setString(6, s.getpassword());
			pst.executeUpdate();	
			System.out.println("data inserted");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static  modelstudentreg loginstudent(modelstudentreg s) {
		modelstudentreg  s1= null;
		try {
			Connection conn =  studentconn.createConnection();
			String sql = "select * from student_regs where email = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getemail());
			pst.setString(2, s.getpassword());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				s1 = new modelstudentreg();
				s1.setfname(rs.getString("fname"));
				s1.setlname(rs.getString("lname"));
				s1.setemail(rs.getString("email"));
				s1.setphone(rs.getLong("phone"));
				s1.setgender(rs.getString("gender"));
				s1.setpassword(rs.getString("password"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	public static void updateseller(modelstudentreg s) {
		try {
			Connection conn =  studentconn.createConnection();
			String sql="update student_regs set fname=?, lname=?, phone=?, email=? , gender=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, s.getfname());
	        pst.setString(2, s.getlname());
	        pst.setLong(3, s.getphone());
	        pst.setString(4, s.getemail());
	        pst.setString(5, s.getgender());
	        pst.setInt(6, s.getid());
	        pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteseller(modelstudentreg s) {
		try {
			Connection conn =  studentconn.createConnection();
			String sql="insert into delete_stud (fname,lname,email,phone,gender) values(?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, s.getfname());
	        pst.setString(2, s.getlname());
	        pst.setString(3, s.getemail());
	        pst.setLong(4, s.getphone());
	        pst.setString(5, s.getgender());
	        pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
