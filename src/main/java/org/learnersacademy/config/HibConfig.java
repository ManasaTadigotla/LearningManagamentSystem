package org.learnersacademy.config;

import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.learnersacademy.lms.entities.AcademicClass;
import org.learnersacademy.lms.entities.Student;
import org.learnersacademy.lms.entities.Subject;
import org.learnersacademy.lms.entities.Teacher;
import org.learnersacademy.lms.entities.User;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import org.hibernate.*;



public class HibConfig {
	
	public static SessionFactory getSessionFactory()
	{
		Configuration config=new Configuration();
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/learners");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		config.setProperties(properties);
		config.addAnnotatedClass(AcademicClass.class);
		config.addAnnotatedClass(Teacher.class);
		config.addAnnotatedClass(Subject.class);
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(User.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		return sessionFactory;
	
	}

}
