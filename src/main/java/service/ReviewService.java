package service;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;

public interface ReviewService {

	Map insertReview(ReviewVo vo);

	List<ReviewVo> getReviewsOne(int t_idx);

}
