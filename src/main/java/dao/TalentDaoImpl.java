package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.TalentVo;


public class TalentDaoImpl implements TalentDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<TalentVo> getTalentList() {
		return sqlSession.selectList("talent.talent_list");
	}

	@Override
	public List<TalentVo> selectList(Map map) {
		return sqlSession.selectList("talent.talent_list_condition", map);
	}

	@Override
	public int selectRowTotal() {
		return sqlSession.selectOne("talent.talent_row_total");
	}

	@Override
	public int selectRowTotal(Map map) {
		return sqlSession.selectOne("talent.talent_condition_row_total",map);
	}

	
	@Override
	public TalentVo selectOne(int t_idx) {
		return sqlSession.selectOne("talent.talent_one", t_idx);
	}

	@Override
	public int insert(TalentVo vo) throws Exception{
		return sqlSession.insert("talent.talent_insert",vo);
	}

	@Override
	public int delete(int t_idx)  throws Exception{
		return sqlSession.delete("talent.talent_delete",t_idx);
	}

	@Override
	public int update(TalentVo vo) throws Exception {
		return sqlSession.update("talent.talent_update",vo);
	}
	@Override
	public int updateStar(int t_idx) throws Exception{
		return sqlSession.update("starscore_update",t_idx);
	}

}
