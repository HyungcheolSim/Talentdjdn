package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.CommonDataSource;

public interface DataSource extends CommonDataSource {
	public Connection getConnection() throws SQLException;
}
