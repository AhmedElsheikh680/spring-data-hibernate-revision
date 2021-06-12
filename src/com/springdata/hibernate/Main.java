package com.springdata.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Data;
import com.springdata.hibernate.model.Info;
import com.springdata.hibernate.model.Person;
import com.springdata.hibernate.model.Student;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Info.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
		session.beginTransaction();
		int id =1;
		Student student = new Student();
		student = session.get(Student.class, id);
		
		student.setName("Saad");
		student.getInfos().get(0).setPhoone("12345");
		student.getInfos().get(1).setPhoone("54321");
		
		
		session.getTransaction().commit();
		
		}catch(Exception e) {
		System.out.println(e.toString());
		}finally {
		session.close();
		}
	}
}


//
//Student student = new Student();
//student.setName("Mohamed");
//
//Info info = new Info();
//info.setPhoone("01124187412");
//
//Info info2 = new Info();
//info2.setPhoone("01527412369");
//
//student.getInfos().add(info);
//student.getInfos().add(info2);
//
//
//info.setStudent(student);
//info2.setStudent(student);
//
//session.save(student);