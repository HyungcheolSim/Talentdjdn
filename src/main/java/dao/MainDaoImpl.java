package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.TalentVo;

public class MainDaoImpl implements MainDao {

	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<TalentVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("main.main_list");
	}
	
	
}
