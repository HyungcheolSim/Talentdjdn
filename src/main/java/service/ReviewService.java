package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewDao;
import vo.ReviewVo;

@Service
public class ReviewService {
	@Autowired
	private ReviewDao reviewDao;

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	public List<ReviewVo> selectReviewList() {
		return reviewDao.getReviewList();
	}

	public ReviewVo selectOneReview(int t_id) {
		return reviewDao.selectOne(t_id);
	}

	public ReviewVo insertReview() {
		ReviewVo reviewVo = new ReviewVo();
		int insert = reviewDao.insert(reviewVo);
		return reviewVo;
	}
}
