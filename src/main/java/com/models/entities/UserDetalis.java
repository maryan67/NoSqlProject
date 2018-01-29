package com.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_details")
public class UserDetalis {
	
	
	@Id @GeneratedValue
	private int id;
	@Column(name = "e_mail")
	private String eMail;
	@Column(name = "adress_id")
	private String adressId;
	@Column(name = "bio")
	private String bio;
	
	public UserDetalis() {}

	public UserDetalis(String eMail, String adressId, String bio) {
		super();

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
