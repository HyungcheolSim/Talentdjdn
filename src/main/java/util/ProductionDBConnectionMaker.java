package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//추후 수정~
public class ProductionDBConnectionMaker implements ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root", "newroot");
		return conn;
		//프로적션 디비 생성 후 변경!
	}
}
