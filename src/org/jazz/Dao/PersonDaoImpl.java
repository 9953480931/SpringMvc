package org.jazz.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import orh.jazz.Model.Person;

@Repository
public class PersonDaoImpl  implements PersonDao{

	

	private SessionFactory sessionfactory;
	
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public void add(Person p) {
		
		Session session= this.sessionfactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void delete(int id) {
	Session session = this.sessionfactory.getCurrentSession();
	Person p =(Person)session.load(Person.class,new Integer(id));
		if(p!=null)
			session.delete(p);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> showList() {
		Session session = this.sessionfactory.getCurrentSession();
	List<Person> p =  session.createQuery("from Person").list();
		return p;
	}

	@Override
	public void update(Person p) {
		Session session = this.sessionfactory.getCurrentSession();
        session.update(p);
		
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionfactory.getCurrentSession();      
        Person p = (Person) session.load(Person.class, new Integer(id));
         return p;
		
	}

}
