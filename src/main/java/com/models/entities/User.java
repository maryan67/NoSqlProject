package com.models.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private int id;

	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String passWord;
	@Column(name = "has_pending_request")
	private boolean hasPendingRequest;
	@Column(name = "details_id")
	private int detailsId;

	public User() {
	}

	public User(String userName, String passWord, boolean hasPendingRequest, int detailsId) {
		this.userName = userName;
		this.passWord = passWord;
		this.hasPendingRequest = hasPendingRequest;
		this.detailsId = detailsId;
	}

	
	public Boolean equals (User user) {
		if (userName.equals(user.getUserName()))
			return true;
		else
			return false;		
	}
	
	
	
	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isHasPendingRequest() {
		return hasPendingRequest;
	}

	public void setHasPendingRequest(boolean hasPendingRequest) {
		this.hasPendingRequest = hasPendingRequest;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

}
