package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import util.ConnectionMaker;
//import util.ProductionDBConnectionMaker;
import util.TalentConnectionMaker;

@Configuration	//애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보
public class DaoFactory {	//IOC/DI 컨테이너
	//userDao와 TalentConnectionMaker 사이 의존관계 주입하는 역할
	//동시에 오브젝트 생성,초기화, 제공등의 작업을 수행하는 컨테이너 
	
	
	@Bean 	//오브젝트 생성을 담당하는 IoC용 메소드라는 표시
//	public UserDao userDao() {
//		return new UserDao(connectionMaker());
//	} 
	
	
	//setter 메소드를 통한 DI
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}
	
	
	/* 이런식으로 dao 추가
	 * public AccountDao accountDao() { return new AccountDao(connectionMaker()); }
	 * public MessageDao messageDao() { return new messageDao(connectionMaker()); }
	 */
	
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new TalentConnectionMaker();
		//ProductionDB 사용시
		//return new ProductionDBConnectionMaker();
	}
}
