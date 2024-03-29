package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.SellerVo;
import vo.ThumbVo;

public class SellerDaoImpl implements SellerDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<SellerVo> selectList(Map map) {
		return sqlSession.selectList("seller.seller_list", map);
	}

	@Override
	public int selectRowTotal(Map map) {
		return sqlSession.selectOne("seller.seller_condition_row_total", map);
	}

	@Override
	public int insert(SellerVo vo) {
		return sqlSession.insert("seller.seller_insert", vo);
	}

	@Override
	public int update(SellerVo vo) {
		return sqlSession.update("seller.seller_update", vo);
	}

	@Override
	public SellerVo selectOne(int s_idx) {
		return sqlSession.selectOne("seller.seller_one", s_idx);
	}

	@Override
	public int delete(int s_idx) {
		return sqlSession.delete("seller.seller_delete",s_idx);
	}

	@Override
	public ThumbVo selectOne(ThumbVo vo) {
		return sqlSession.selectOne("seller.thumb_list", vo);
	}

	@Override
	public int delete_thumb(ThumbVo vo) {
		return sqlSession.delete("seller.thumb_delete",vo);
	}

	@Override
	public int selectCount(int s_idx) {
		return sqlSession.selectOne("seller.thumb_count", s_idx);
	}

	@Override
	public int insert_thumb(ThumbVo vo) {
		return sqlSession.insert("seller.thumb_insert", vo);
	}

	@Override
	public int update_tcount(int s_idx) {
		return sqlSession.update("seller.thumb_update",s_idx );
	}


}
