	package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.ReviewVo;


public class ReviewDaoImpl implements ReviewDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ReviewVo> getReviewList() {
		return sqlSession.selectList("review.review_list");
	}

	@Override
	public ReviewVo selectOne(int r_idx) {
		return sqlSession.selectOne("review.review_one", r_idx);
	}

	@Override
	public List<ReviewVo> getReviewsForOne(int t_idx){
		return sqlSession.selectList("review.review_list_for_one",t_idx);
	}
	
	@Override
	public int insert(ReviewVo vo)  throws Exception{
		return sqlSession.insert("review.review_insert",vo);
	}

	@Override
	public int delete(int r_idx) throws Exception {
		return sqlSession.delete("review.review_delete",r_idx);
	}

	@Override
	public int update(ReviewVo vo) throws Exception {
		return sqlSession.update("review.review_update",vo);
	}

	@Override
	public List<ReviewVo> selectList(Map map) {
		return sqlSession.selectList("review.review_list_condition",map);
	}

	@Override
	public int selectRowTotal() {
		return sqlSession.selectOne("review.review_row_total");
	}

	@Override
	public int selectRowTotal(int t_idx) {
		return sqlSession.selectOne("review.review_condition_row_total",t_idx);
	}

}
