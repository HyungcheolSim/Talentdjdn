package com.talent.myapp;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;

/*
 * DataSourceTest
 * @Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/**/root-context.xml"})
public class UserDaoTest {
	@Test
	public void test() throws ClassNotFoundException,SQLException{
		//ApplicationContext context= new AnnotationConfigApplicationContext(DaoFactory.class);
		//xml 사용시
		ApplicationContext context= new GenericXmlApplicationContext("/springbook/xml/applicationContext.xml");
		UserDao dao2= context.getBean("userDao",UserDao.class);
		UserDao dao= context.getBean("userDao",UserDao.class);
		
		System.out.println(dao2);
		System.out.println(dao);
		
	}
	
}
