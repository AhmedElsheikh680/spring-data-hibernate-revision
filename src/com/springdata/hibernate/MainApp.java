package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.springdata.hibernate.model.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
//		int id =1;
		try {
			session.beginTransaction();
			
			Query q1 = session.createQuery("select Max(id) from Employee");
			Query q2 = session.createQuery("select Min(id) from Employee");
			Query q3 = session.createQuery("select sum(age) from Employee");
			Query q4 = session.createQuery("select count(address) from Employee");
			Query q5 = session.createQuery("select count(distinct address) from Employee");
			
			System.out.println("Max " +q1.list().get(0));
			System.out.println("Min " + q2.list().get(0));
			System.out.println("Sum " + q3.list().get(0));
			System.out.println("Count " + q4.list().get(0));
			System.out.println("Count Distinct " + q5.list().get(0));
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			session.close();
		}
			
	}
}


//SessionFactory sessionFactory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Employee.class)
//								.buildSessionFactory();
//Session session = sessionFactory.getCurrentSession();
//
//// TO Save Object
//// Declare Object
////Employee emp = new Employee("Mostafa Mahmoud", 40, "Giza");
////emp.setFullName("Ahmed Elsheikh");
////emp.setAge(25);
////emp.setAddress("Cairo");
//
//long id = 1;
//
//try {
//// begin transaction
//session.beginTransaction();
//// Update EMployee
////Employee emp = new Employee("Amira Ahmed", 25, "Egypt");
////emp.setId(id);
////session.update(emp);
//// To Get Employee By ID
////Employee emp = session.get(Employee.class, id);
//
//// Delete Employee
//Employee emp = new Employee();
//emp.setId((long) 3); 
//session.delete(emp);
//// save object
////session.save(emp);
//// commmit transaction
//session.getTransaction().commit();
//System.out.println("FullName: " +emp.getFullName() + " " + "Address: "+ emp.getAddress());
//}catch(Exception e) {
//System.out.println(e.toString());
//}finally {
//session.close();
//}
//
//
//
//
//////Connect To DB
////String url = "jdbc:mysql://localhost:3306/employee";
////String username = "root";
////String password = "";
////
////try {
////
////	Connection conn = DriverManager.getConnection(url, username, password);
////	System.out.println("COnnected!!");
////	System.out.println(conn);
////} catch (SQLException e) {
////	// TODO Auto-generated catch block
////	e.printStackTrace();
//////	System.out.println(e.toString());
////



//Query query = session.createQuery("from Employee emp where emp.id = :v1 or fullName= :v2");
//query.setInteger("v1", id);
//query.setString("v2", "Ahmed Mohamed");
//List<Employee> emps = query.list();
//for(Employee e: emps) {
//	System.out.println(e.getFullName());
//}
////}

