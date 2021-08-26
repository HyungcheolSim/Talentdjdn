package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SellerVo;
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
	public List<TalentVo> selectTList() {
		return sqlSession.selectList("main.main_tlist");
	}

	@Override
	public List<TalentVo> selectPList() {
		return sqlSession.selectList("main.main_plist");
	}

	@Override
	public List<SellerVo> selectSList() {
		return sqlSession.selectList("main.main_slist");
	}


	
}
