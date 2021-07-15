package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import util.ConnectionMaker;
import util.CountingConnetionMaker;
import util.TalentConnectionMaker;

@Configuration
public class CountingDaoFactory {
	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnetionMaker(realConnectionMaker());
	}
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new TalentConnectionMaker();
	}
}
