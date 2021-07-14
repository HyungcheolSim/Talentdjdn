package com.talent.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/*
 * MysqlConnectionTest
 * @Test
 */
public class MYSQLConnectionTest {
	//각자의 local url,user,pw 확인
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/talentdjdn?useSSL=false";
	private static final String USER="root";
	private static final String PW="newroot";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		//AutoCloseable 인터페이스를 구현한 타입의 변수->먼말이누?
		try (Connection conn1=DriverManager.getConnection(URL,USER,PW);
			 Connection conn2=DriverManager.getConnection(URL,USER,PW);){
			System.out.println("=====mysql connection test start =====");
			System.out.println(conn1);
			System.out.println(conn2);
			System.out.println("=====mysql connection test end =====");
			
		}
	}
}
