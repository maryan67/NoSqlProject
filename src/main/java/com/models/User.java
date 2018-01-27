package com.models;

public class User {

	private int id;
	private String userName;
	private String passWord;
	private boolean hasPendingRequest;
	private int detailsId;

	public User() {
	}

	public User(int iD, String userName, String passWord, boolean hasPendingRequest, int detailsId) {
		id = iD;
		this.userName = userName;
		this.passWord = passWord;
		this.hasPendingRequest = hasPendingRequest;
		this.detailsId = detailsId;
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
