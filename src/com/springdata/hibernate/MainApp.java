package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Employee;

public class MainApp {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();


		
//		//Connect To DB
//		String url = "jdbc:mysql://localhost:3306/employee";
//		String username = "root";
//		String password = "";
//	
//		try {
//		
//			Connection conn = DriverManager.getConnection(url, username, password);
//			System.out.println("COnnected!!");
//			System.out.println(conn);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////			System.out.println(e.toString());
//
//		}
		
	}
}
