package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TalentConnectionMaker implements ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "newroot");
		return conn;
	}
}
