	package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ReviewVo;

public class ReviewDaoImpl implements ReviewDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ReviewVo> getReviewList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("review.review_list");
	}

	@Override
	public ReviewVo selectOne(int r_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("review.review_one", r_id);
	}

	@Override
	public List<ReviewVo> getReviewsForOne(int t_id){
		return sqlSession.selectList("review.review_list_for_one",t_id);
	}
	
	@Override
	public int insert(ReviewVo vo)  throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.insert("review.review_insert",vo);
	}

	@Override
	public int delete(int r_id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReviewVo vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
