package com.models;

public class UserDetalis {
	
	private int id;
	private String eMail;
	private String adressId;
	private String bio;
	
	public UserDetalis() {}

	public UserDetalis(int id, String eMail, String adressId, String bio) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.adressId = adressId;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAdressId() {
		return adressId;
	}

	public void setAdressId(String adressId) {
		this.adressId = adressId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	
	

}
