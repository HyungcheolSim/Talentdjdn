package dao;

import java.util.List;

import vo.ReviewVo;

public interface ReviewDao {

	
	public List<ReviewVo> getReviewList();
	
	
	public ReviewVo selectOne(int r_idx);
	
	public List<ReviewVo> getReviewsForOne(int t_idx);
	
	
	
	public int insert(ReviewVo vo) throws Exception;
	
	
	public int delete(int r_idx) throws Exception;

	
	public int update(ReviewVo vo) throws Exception;
}
