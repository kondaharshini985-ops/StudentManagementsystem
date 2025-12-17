package com.pentagon.student.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





import com.pentagon.student.db.Connector;
import com.pentagon.studentDTO.Student;

public class StudentDAOImlp implements StudentDAO{
	Connection conn=null;
	Student student = new Student();
	
	public StudentDAOImlp() {
	 conn =Connector.getConnnection();	
	}

	@Override
	public boolean insertStudent(Student s) {
		String query ="insert into student(sid,phone,name,email,branch,location,password,date) VALUES (0,?,?,?,?,?,?,SYSDATE())";
        int i=0;
		try {
        	 PreparedStatement ps =conn.prepareStatement(query);
        	 ps.setLong(1, s.getPhone());
        	 ps.setString(2, s.getName());
        	 ps.setString(3, s.getEmail());
        	 ps.setString(4, s.getBranch());
        	 ps.setString(5, s.getLocation());
        	 ps.setString(6, s.getPassword());
        	 i=ps.executeUpdate();
        	
        	 		 
         }catch(Exception e){
        	e.printStackTrace(); 
         }
		 if(i>0) {
    		 System.out.println("student info inserted successfuly");
    		 return true;
    		
    	 }else {
    		 System.out.println("failed to insert");
    		 return false;
    	 }

		
	}

	@Override
	public boolean updateStudent(Student s) {
		String query  ="UPDATE STUDENT SET NAME=?,PHONE=?,EMAIL=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE SID=?";
		int i =0;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getSid());
			i =ps.executeUpdate();
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(i>0) {
			System.out.println("succ");
			return true;
		}else {
			return false;	
		}
		
	}

	@Override
	public boolean deleteStudent(Student s) {
		String query = "DELETE FROM STUDENT WHERE PHONE=?";
		int i=0;
		try {
		PreparedStatement ps =conn.prepareStatement(query);
		ps.setLong(1, s.getPhone());
		i=ps.executeUpdate();
		
		}
		catch(Exception e){
			
		}
		if(i>0) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public Student getStudent(String password, String email) {
		String query ="SELECT * FROM STUDENT WHERE PASSWORD=? AND EMAIL=?";
		ResultSet rSet=null;
		Student s = null;
		
		try {
			PreparedStatement pStatement =conn.prepareStatement(query);
			pStatement.setString(1, password);
			pStatement.setString(2, email);
			rSet =pStatement.executeQuery();
			while(rSet.next()) {
				s=new Student();  //rset.next lo column vundi ante inka object create chestam ledante led
				s.setSid(rSet.getInt("SID"));
			    s.setName(rSet.getString("name"));
			    s.setEmail(rSet.getString("email"));
			    s.setBranch(rSet.getString("branch"));
			    s.setPassword(rSet.getString("password"));
			    s.setLocation(rSet.getString("location"));
			    s.setPhone(rSet.getLong("phone"));    
			    
			}
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if(s!= null) {
			return s;
		
		}else {
		return null;
		}
	}

	@Override
	public Student getStudentByName(String email, long phone) {
		String query ="select * from student where email=? and phone =?";
		Student s =null;
		PreparedStatement p=null;
		ResultSet rs = null;
		try {
		p =conn.prepareStatement(query);
		p.setString(1, email);
		p.setLong(2, phone);
		rs=p.executeQuery();
		while(rs.next()) {
			s=new Student();	
			s.setSid(rs.getInt("sid"));
			s.setName(rs.getString("name"));
		    s.setPhone(rs.getLong("phone"));
		    s.setEmail(rs.getString("email"));
		    s.setBranch(rs.getString("branch"));
		    s.setPassword(rs.getString("password"));
		    s.setLocation(rs.getString("location"));
		
		}
		if(s!=null) 
			return s;
		
		else 
			System.out.println("Student not found");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		Student s= null;
	   ArrayList<Student> list = new ArrayList<Student>();
	   ResultSet r = null;
	   String query ="SELECT * FROM STUDENT";
	   
	   try {
		   PreparedStatement ps =conn.prepareStatement(query);
		   r =ps.executeQuery();
		   while(r.next()) {
			  s= new Student();
			  s.setSid(r.getInt("sid"));
			  s.setName(r.getString("name"));
			  s.setPhone(r.getLong("phone"));
			  s.setEmail(r.getString("email"));
			  s.setBranch(r.getString("branch"));
			  s.setLocation(r.getString("location"));
			  s.setPassword(r.getString("password"));
			  list.add(s);
			  
		   }
		   
		   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
		return list ;
	}
	

}
