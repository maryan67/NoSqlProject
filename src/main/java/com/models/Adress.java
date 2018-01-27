package com.models;

public class Adress {
	
	private int id;
	private String street;
	private int streetNumber;
	private int blockNumber;
	private String zipCode;
	
	public Adress () {}

	
	
	public Adress(int id, String street, int streetNumber, int blockNumber, String zipCode) {
		super();
		this.id = id;
		this.street = street;
		this.streetNumber = streetNumber;
		this.blockNumber = blockNumber;
		this.zipCode = zipCode;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	

}
