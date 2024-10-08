package com.fit.entity;

public class User {
	private String fname;
	private String lname;
	private String email;
	private String reEmail;
	private String password;
	private String dob;
	private String gender;

	public User() {
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReEmail() {
		return reEmail;
	}

	public void setReEmail(String reEmail) {
		this.reEmail = reEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User(String fname, String lname, String email, String reEmail, String password, String dob, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.reEmail = reEmail;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
	}

}
