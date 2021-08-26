package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewDao;
import mycommon.MyConstant;
import util.Paging;
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
		// review insert 후 결과 result로 map에 넣어 리턴
		String c_content = vo.getR_content().replaceAll("\n", "<br>");
		vo.setR_content(c_content);

		int res = 0;
		try {
			res = reviewDao.insert(vo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map map = new HashMap();
		map.put("result", (res == 1) ? "success" : "fail"); // { "result" : "success" }

		return map;
	}

	@Override
	public List<ReviewVo> getReviewsOne(int t_idx) { 
		return reviewDao.getReviewsForOne(t_idx);
	}

	@Override
	public Map getPagingReviewList(int t_idx,int nowPage) {
		// T_idx에 해당하는 페이징된 리뷰목록 출력
		int start = (nowPage - 1) * MyConstant.Review.BLOCK_LIST + 1;
		int end = start + MyConstant.Review.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("t_idx", t_idx);
		map.put("start", start);
		map.put("end", end);

		List<ReviewVo> reviewlist = reviewDao.selectList(map);
		
	      int row_total = reviewDao.selectRowTotal(t_idx);
	      
	      String pageMenu = Paging.getReviewPaging(nowPage, row_total, 
	                                      MyConstant.Review.BLOCK_LIST, 
	                                      MyConstant.Review.BLOCK_PAGE);
	      
		Map resultMap = new HashMap();
		resultMap.put("reviewlist", reviewlist);
		if(row_total>0){
			resultMap.put("pageMenu", pageMenu);
			}
		return resultMap;
	}
}