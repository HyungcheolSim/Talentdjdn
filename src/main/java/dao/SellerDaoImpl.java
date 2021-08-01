package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.BoardVo;
import vo.SellerVo;

public class SellerDaoImpl implements SellerDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<SellerVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("seller.seller_list", map);
	}

	@Override
	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("seller.seller_condition_row_total", map);
	}

	@Override
	public int insert(SellerVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("seller.seller_insert", vo);
	}

	@Override
	public int update(SellerVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("seller.seller_update", vo);
	}

	@Override
	public SellerVo selectOne(int s_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("seller.seller_one", s_idx);
	}

	@Override
	public int delete(int s_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("seller.seller_delete",s_idx);
	}


}
