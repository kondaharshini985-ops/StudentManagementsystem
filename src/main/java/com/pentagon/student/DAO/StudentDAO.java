package com.pentagon.student.DAO;
import java.util.ArrayList;

import com.pentagon.studentDTO.Student;

public interface StudentDAO {
	boolean insertStudent(Student s);
	boolean updateStudent(Student s);
	boolean deleteStudent(Student s);
	
	Student getStudent(String password,String email);
	Student getStudentByName(String email,long phone);
	ArrayList<Student> getAllStudents();
	

}
