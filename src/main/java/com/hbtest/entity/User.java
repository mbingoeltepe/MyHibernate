package com.logging.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;
	private String userPassword;
	
	public User() {
	}

	public User(int id, String userName, String userPassword) {
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getuserPassword() {
		return userPassword;
	}
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "Person [id=" + this.id + ", userName=" + this.userName + ", userPassword=" + this.userPassword + "]";
	}

}
