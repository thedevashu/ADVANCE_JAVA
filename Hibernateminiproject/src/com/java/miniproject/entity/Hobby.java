package com.java.miniproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_hobby")
public class Hobby {
	@Id
	@Column(name="hobby_id")
	private int hobbyId;
	
	@ManyToOne
	private User userId;
	@Column(name="hobby")
	private String hobby;
	
	
	public Hobby() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hobby(int hobbyId, User userId, String hobby) {
		super();
		this.hobbyId = hobbyId;
		this.userId = userId;
		this.hobby = hobby;
	}
	public int getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
