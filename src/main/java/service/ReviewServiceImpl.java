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
import vo.TalentVo;

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

		// Map -> JSON�ڵ�� ��ȯ => �������
		Map map = new HashMap();

		map.put("result", (res == 1) ? "success" : "fail"); // { "result" : "success" }

		return map;
	}

	@Override
	public List<ReviewVo> getReviewsOne(int t_idx) { 
		return reviewDao.getReviewsForOne(t_idx);
	}

	@Override
	public Map getPagingReviewList(int t_idx, int nowPage, String search, String search_text) {
		int start = (nowPage - 1) * MyConstant.Board.BLOCK_LIST + 1;
		int end = start + MyConstant.Board.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("t_idx",t_idx);
		map.put("start", start);
		map.put("end", end);

		if (search.equals("name")) {
			map.put("name", search_text);
		} else if (search.equals("star")) {
			map.put("star", search_text);
		}
		List<ReviewVo> reviewlist = reviewDao.selectList(map);

		int rowTotal = reviewDao.selectRowTotal(map);

		String search_filter = String.format("&search=%s&search_text=%s", search, search_text);

		String pageMenu = Paging.getPaging("list.do", nowPage, rowTotal, search_filter,
				MyConstant.Board.BLOCK_LIST, MyConstant.Board.BLOCK_PAGE);

		Map resultMap = new HashMap();
		resultMap.put("reviewlist", reviewlist);
		if (rowTotal > 0) {
			resultMap.put("pageMenu", pageMenu);
		}

		return resultMap;
	}

}
