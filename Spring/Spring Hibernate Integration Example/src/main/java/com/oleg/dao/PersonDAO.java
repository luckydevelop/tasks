package com.oleg.dao;

import java.util.List;

import com.oleg.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
