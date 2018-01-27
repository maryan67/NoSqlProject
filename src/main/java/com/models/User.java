package com.models;

public class User {

	private int ID;
	private String userName;
	private String passWord;
	private String eMail;
	private boolean hasPendingRequest;

	public User() {
	}

	public User(int iD, String userName, String passWord, String eMail, boolean hasPendingRequest) {
		ID = iD;
		this.userName = userName;
		this.passWord = passWord;
		this.eMail = eMail;
		this.hasPendingRequest = hasPendingRequest;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean isHasPendingRequest() {
		return hasPendingRequest;
	}

	public void setHasPendingRequest(boolean hasPendingRequest) {
		this.hasPendingRequest = hasPendingRequest;
	}

}
