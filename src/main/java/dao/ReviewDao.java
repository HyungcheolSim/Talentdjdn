package dao;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;
import vo.TalentVo;

public interface ReviewDao {

	
	public List<ReviewVo> getReviewList();
	
	public List<ReviewVo> selectList(Map map);
	
	public int selectRowTotal();
	
	public int selectRowTotal(Map map);
	
	public ReviewVo selectOne(int r_idx);
	
	public List<ReviewVo> getReviewsForOne(int t_idx);
	
	
	
	public int insert(ReviewVo vo) throws Exception;
	
	
	public int delete(int r_idx) throws Exception;

	
	public int update(ReviewVo vo) throws Exception;
}
