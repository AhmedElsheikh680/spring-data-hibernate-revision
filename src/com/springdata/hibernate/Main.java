package com.springdata.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Data;
import com.springdata.hibernate.model.Person;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Data.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
		session.beginTransaction();
		
		Person p = new Person();
		p.setId(1);
		Person person = session.get(Person.class, p.getId());
		session.delete(person);
		session.getTransaction().commit();
		
		}catch(Exception e) {
		System.out.println(e.toString());
		}finally {
		session.close();
		}
	}
}
