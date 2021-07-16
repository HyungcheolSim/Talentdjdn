package springbook.test;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.CountingDaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;
import util.CountingConnetionMaker;

public class UserDaoConnectionCountingTest {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao",UserDao.class);
		//Dao 사용 코드
		User user1=new User();
		user1.setId("shc1161");
		user1.setName("신은철");
		user1.setPassword("123123");
		dao.add(user1);
		System.out.print(user1.getId()+ " 등록 성공");
		User user2 = dao.get(user1.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		CountingConnetionMaker ccm = context.getBean("connectionMaker",CountingConnetionMaker.class);
		System.out.println("Connection counter : "+ccm.getCounter());

	}

}
