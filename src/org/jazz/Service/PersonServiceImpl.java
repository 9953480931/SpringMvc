package org.jazz.Service;

import java.util.List;

import org.jazz.Dao.PersonDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orh.jazz.Model.Person;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	PersonDao personDao;
	@Override
	public void add(Person p) {
		this.personDao.add(p);
		
	}

	@Override
	public void delete(int id) {
		this.personDao.delete(id);
		
	}

	@Override
	public List<Person> showList() {
		return  this.personDao.showList();
		
	}

	@Override
	public void update(Person p) {
		this.personDao.update(p);
		
	}

	@Override
	public Person getPersonById(int id) {
		
		return this.personDao.getPersonById(id);
	}

}
