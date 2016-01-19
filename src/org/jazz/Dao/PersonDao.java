package org.jazz.Dao;

import java.util.List;

import orh.jazz.Model.Person;

public interface PersonDao {
	public void add(Person p);
	public void delete(int id);
	public List<Person> showList();
	public void update(Person p);
	public Person getPersonById(int id);

}
