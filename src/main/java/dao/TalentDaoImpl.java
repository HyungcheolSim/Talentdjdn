package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.TalentVo;


public class TalentDaoImpl implements TalentDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<TalentVo> getTalentList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("talent.talent_list");
	}

	@Override
	public TalentVo selectOne(int t_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("talent.talent_one", t_id);
	}

	@Override
	public int insert(TalentVo vo){
		// TODO Auto-generated method stub
		return sqlSession.insert("talent.talent_insert",vo);
	}

	@Override
	public int delete(int t_id) {
		// TODO Auto-generated method stub
		return sqlSession.delete("talent.talent_delete",t_id);
	}

	@Override
	public int update(TalentVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("talent.talent_update",vo);
	}

}
