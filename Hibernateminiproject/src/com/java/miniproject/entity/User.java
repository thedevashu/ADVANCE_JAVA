package com.java.miniproject.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name= "user_info")

public class User {
	@Id
	@Column(name="user_id")
	private int id;
	@Column(name="firstname")
	private String fname;
	@Column(name="lastname")
	private String lname;
	@Column(name="mobile")
	private String mobileNo;
	@Column(name="email")
	private String emailId;
	@Column(name="username")
	private String uname;
	@Column(name="password")
	private String pass;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="hobby_id")
	private Set<Hobby> hobbies;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String fname, String lname, String mobileNo, String emailId, String uname, String pass) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.uname = uname;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Set<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	
}
