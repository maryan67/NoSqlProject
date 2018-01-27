package com.models;

public interface CRUDEntity {
	
	public void update(Object o);
	public void create(Object o);
	public void delete(int id);
	public void findById(Object o);

}
