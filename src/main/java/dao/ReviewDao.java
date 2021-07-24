package dao;

import java.util.List;

import vo.ReviewVo;

public interface ReviewDao {

	
	public List<ReviewVo> getReviewList();
	
	
	public ReviewVo selectOne(int r_id);
	
	public List<ReviewVo> getReviewsForOne(int t_id);
	
	public int insert(ReviewVo vo);
	
	
	public int delete(int r_id);

	
	public int update(ReviewVo vo);
}
