package util;

import java.sql.Connection;
import java.sql.SQLException;
//필요 없음 연습용
public class CountingConnetionMaker implements ConnectionMaker{
	int count=0;
	private ConnectionMaker realConnectionMaker;
	
	public CountingConnetionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker=realConnectionMaker;
	}
	
	public Connection makeConnection() throws ClassNotFoundException,SQLException{
		this.count++;
		return realConnectionMaker.makeConnection();
	}
	public int getCounter() {
		return this.count;
	}
}
