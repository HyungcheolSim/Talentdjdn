package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import springbook.user.domain.User;
import util.DataSource;

public class UserDao {
	private DataSource dataSource;// 설정이후 바뀌지 않는 읽기전용 인스턴스 변수
	//생성를 통한(의존관계 주입)
//	public UserDao(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}//런타임 의존관계 생성 완료!
//	
	public UserDao() {}
	
	//setter 메소드를 통한 DI
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into users(id,name,password) values(?,?,?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

	}



	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from users where id= ?");
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		pstmt.close();
		conn.close();

		return user;
	}
}
