package com.models;

public class Friendship {

	private int id;
	private boolean isConfirmed;
	private int idLeft;
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
