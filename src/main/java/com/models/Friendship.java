package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friendships")
public class Friendship {

	@Id @GeneratedValue
	private int id;
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	@Column(name="idLeft")
	private int idLeft;
	@Column(name="idRight")
	private int idRight;

	public Friendship() {
	}

	public Friendship(int id, boolean isConfirmed, int idLeft, int idRight) {
		super();
		this.id = id;
		this.isConfirmed = isConfirmed;
		this.idLeft = idLeft;
		this.idRight = idRight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public int getIdLeft() {
		return idLeft;
	}

	public void setIdLeft(int idLeft) {
		this.idLeft = idLeft;
	}

	public int getIdRight() {
		return idRight;
	}

	public void setIdRight(int idRight) {
		this.idRight = idRight;
	}

}
