package com.pentagon.studentDTO;

public class Student {
//pojo class
	private int sid;
	private String name;
	private long phone ;
	private String email;
	private String branch;
	private String location;
	private String password;
	private String confirmpassword;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	   @Override
	    public String toString() {
	        return "Student Details: [SID=" + sid + 
	               ", Name=" + name + 
	               ", Phone=" + phone + 
	               ", Email=" + email + 
	               ", Branch=" + branch + 
	               ", Location=" + location + "]";
	    }
	}
	
	
