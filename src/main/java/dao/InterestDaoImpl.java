package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.InterestVo;

public class InterestDaoImpl implements InterestDao {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<InterestVo> selectList(int m_idx) {
		return sqlSession.selectList("interest.interest_list", m_idx);
	}

	@Override
	public int delete(int i_idx) {
		return sqlSession.delete("interest.interest_delete", i_idx);
	}

	@Override
	public int insert(InterestVo vo) {
		return sqlSession.insert("interest.interest_insert",vo);
	}

	@Override
	public InterestVo selectOne(InterestVo vo) {
		return sqlSession.selectOne("interest.interest_one", vo);
	}
	
	
}
