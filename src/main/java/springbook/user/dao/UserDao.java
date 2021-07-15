package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import springbook.user.domain.User;
import util.ConnectionMaker;

public class UserDao {
	private ConnectionMaker connectionMaker;// 설정이후 바뀌지 않는 읽기전용 인스턴스 변수
	//생성를 통한(의존관계 주입)
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}//런타임 의존관계 생성 완료!
	
	  //IoC개념을 포함하지만 DI적용 안됨.
	// DaoFactory를 사용
//	public UserDao() { DaoFactory daoFactory = new DaoFactory();
//		this.connectionMaker = daoFactory.connectionMaker(); }
//	 
	public UserDao() {}
	//21~24 코드가 27~32로 변환시키면 의존관계 검색을 사용해 가져올 수 있다.
	//의존관계 검색 사용하는 UserDao 생성자 
//	  public UserDao() {
//	  AnnotationConfigApplicationContext context= new
//	  AnnotationConfigApplicationContext(DaoFactory.class);
//	  this.connectionMaker=context.getBean("connectionMaker",ConnectionMaker.class);
//	  }
	 
	
	//setter 메소드를 통한 DI
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into users(id,name,password) values(?,?,?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

	}



	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = connectionMaker.makeConnection();
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
