package com.springdata.hibernate;

import java.awt.font.TextLayout.CaretPolicy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Car;
import com.springdata.hibernate.model.Color;
import com.springdata.hibernate.model.Data;
import com.springdata.hibernate.model.Info;
import com.springdata.hibernate.model.Person;
import com.springdata.hibernate.model.Student;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(Color.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
		session.beginTransaction();
		
		// Save 
		Car car1 = new Car("Car1");
		Car car2 = new Car("Car2");
		Car car3 = new Car("Car3");
		/////////////
		Color color1 = new Color("Red");
		Color color2 = new Color("Green");
		Color color3 = new Color("Blue");
		////////////
		car1.getColors().add(color1);
		car1.getColors().add(color2);
		car1.getColors().add(color3);
		
		car2.getColors().add(color1);
		car2.getColors().add(color2);
		car2.getColors().add(color3);
		
		car3.getColors().add(color1);
		car3.getColors().add(color2);
		car3.getColors().add(color3);
		
		session.save(car1);
		session.save(car2);
		session.save(car3);
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