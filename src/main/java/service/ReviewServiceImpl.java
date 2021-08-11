package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewDao;
import vo.ReviewVo;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public Map insertReview(ReviewVo vo) {
		// TODO Auto-generated method stub
		String c_content = vo.getR_content().replaceAll("\n", "<br>");
		vo.setR_content(c_content);

		int res = 0;
		try {
			res = reviewDao.insert(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Map -> JSON�ڵ�� ��ȯ => �������
		Map map = new HashMap();
		
		map.put("result", (res==1) ? "success" : "fail"); // { "result" : "success" }
		
		return map;
	}

	@Override
	public List<ReviewVo> getReviewsOne(int t_idx) {
		// TODO Auto-generated method stub
		return reviewDao.getReviewsForOne(t_idx);
	}
	
	
}
