package org.jazz.Service;

import java.util.List;

import orh.jazz.Model.Person;

public interface PersonService {

	public void add(Person p);
	public void delete(int id);
	public List<Person> showList();
	public void update(Person p);
	public Person getPersonById(int id);
}
