	package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;
import vo.ReviewVo;

public class MemberDaoImpl implements MemberDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberVo> selectList() {
		return sqlSession.selectList("member.member_list");
	}

	@Override
	public MemberVo selectOne(int m_idx) {
		return sqlSession.selectOne("member.member_one_m_idx", m_idx);
	}

	@Override
	public int insert(MemberVo vo) {
		return sqlSession.insert("member.member_insert",vo);
	}

	@Override
	public int delete(int m_idx) {
		return sqlSession.delete("member.member_delete",m_idx);
	}

	@Override
	public int update(MemberVo vo) {
		return sqlSession.update("member.member_update",vo);
	}

	@Override
	public MemberVo selectOne(String m_id) {
		return sqlSession.selectOne("member.member_one_m_id", m_id);
	}

	@Override
	public List<ReviewVo> selectList(Map map) {
		return sqlSession.selectList("member.member_page_list",map);
	}

	@Override
	public int selectRowTatal() {
		return sqlSession.selectOne("member.member_row_total");
	}

	@Override
	public List selectSellerList(int m_idx) {
		return sqlSession.selectList("member.member_seller_list", m_idx);
	}

}
