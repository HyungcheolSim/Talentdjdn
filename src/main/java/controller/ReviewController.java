package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ReviewService;
import vo.ReviewVo;

@Controller
@RequestMapping("/review/")

public class ReviewController {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	ReviewService reviewService;

	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@RequestMapping("insert.do")
	@ResponseBody
	public Map insert(ReviewVo vo) {
		//리뷰 등록
		return reviewService.insertReview(vo);
	}

	@RequestMapping("list.do")
	public String getReviewsforonetalent(int t_idx,@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
										Model model) {
		//리뷰 페이징하고 service에서 받은 map을 model로 넘겨준 후 reviewlist페이지로 다시 이동
		Map map=reviewService.getPagingReviewList(t_idx,nowPage);
		model.addAttribute("map", map);
		
		return "_jsp/review/review_list";
	}

}
