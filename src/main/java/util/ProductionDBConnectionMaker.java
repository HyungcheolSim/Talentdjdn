
package util;
  
  import java.io.PrintWriter;
import java.sql.Connection; import java.sql.DriverManager;
  import java.sql.SQLException; //추후 수정~ 
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
  public class ProductionDBConnectionMaker implements DataSource {
	  public Connection getConnection() throws SQLException{
		  
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root",  "newroot");
		  return conn; //프로적션 디비 생성 후 변경! 
	  }

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	} 
  }
