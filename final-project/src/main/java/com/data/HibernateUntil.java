package com.data;

import java.util.Properties;

import com.cart.Cart;
import com.item.Item;
import com.tree.Tree;
import com.user.User;
import com.userInfo.UserInfo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUntil {
	private static SessionFactory sessionFactory;

	// public static SessionFactory getSessionFacoty() {
	// 	if (sessionFactory == null) {
	// 		try {
	// 			Configuration configuration = new Configuration();
	// 			Properties settings = new Properties();
	// 			settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
	// 			settings.put(Environment.DRIVER, "org.postgresql.Driver");
	// 			settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
	// 			settings.put(Environment.USER, "postgres");
	// 			settings.put(Environment.PASS, "2762001T");
	// 			settings.put(Environment.SHOW_SQL, "true");
	// 			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	// 			configuration.setProperties(settings);
	// 			configuration.addAnnotatedClass(UserInfo.class);
	// 			configuration.addAnnotatedClass(User.class);
	// 			configuration.addAnnotatedClass(Item.class);
	// 			configuration.addAnnotatedClass(Tree.class);
	// 			configuration.addAnnotatedClass(Cart.class);
	// 			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// 					.applySettings(configuration.getProperties()).build();
	// 			System.out.println("Hibernate Java Config serviceRegistry created");
	// 			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	// 			return sessionFactory;
	// 		} catch (Exception e) {
	// 			e.printStackTrace();
	// 		}

	// 	}
	// 	return sessionFactory;
	// }


	//for heroku
	public static SessionFactory getSessionFacoty() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://ec2-54-225-203-79.compute-1.amazonaws.com:5432/dcdsr8kojqufrb");
				settings.put(Environment.USER, "upcicwbgaetprk");
				settings.put(Environment.PASS, "81f654c1726a3727d8f031d31af5b182702be47f5c193beaa1aaf1fc64c6dc5f");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO,"update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(UserInfo.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Item.class);
				configuration.addAnnotatedClass(Tree.class);
				configuration.addAnnotatedClass(Cart.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sessionFactory;
	}

	// public static SessionFactory getSessionFacoty() {
	// 	if (sessionFactory == null) {
	// 		try {
	// 			Configuration configuration = new Configuration();
	// 			Properties settings = new Properties();
	// 			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	// 			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	// 			settings.put(Environment.URL, "jdbc:mysql://database-1.ctmpvntqk27b.ap-southeast-1.rds.amazonaws.com:3306/postgres");
	// 			settings.put(Environment.USER, "admin");
	// 			settings.put(Environment.PASS, "chobeosuiroi:sadcow");
	// 			settings.put(Environment.SHOW_SQL, "true");
	// 			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	// 			settings.put(Environment.HBM2DDL_AUTO,"update");

	// 			configuration.setProperties(settings);
	// 			configuration.addAnnotatedClass(UserInfo.class);
	// 			configuration.addAnnotatedClass(User.class);
	// 			configuration.addAnnotatedClass(Item.class);
	// 			configuration.addAnnotatedClass(Tree.class);
	// 			configuration.addAnnotatedClass(Cart.class);
	// 			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// 					.applySettings(configuration.getProperties()).build();
	// 			System.out.println("Hibernate Java Config serviceRegistry created");
	// 			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	// 			return sessionFactory;
	// 		} catch (Exception e) {
	// 			e.printStackTrace();
	// 		}

	// 	}
	// 	return sessionFactory;
	// }
}
