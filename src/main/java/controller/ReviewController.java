package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReviewDao;
import service.ReviewService;
import vo.MemberVo;
import vo.ReviewVo;
import vo.TalentVo;

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
		
		return reviewService.insertReview(vo);
	}

	/*
	 * @RequestMapping("list.do") public String getReviewsforonetalent(int
	 * t_idx,Model model) { List<ReviewVo> reviewlist =
	 * reviewService.getReviewsOne(t_idx);
	 * 
	 * model.addAttribute("reviewlist", reviewlist);
	 * 
	 * return "_jsp/review/review_list"; }
	 */
	@RequestMapping("list.do")
	public String getReviewsforonetalent(int t_idx,@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text,Model model) {
		//List<ReviewVo> reviewlist = reviewService.getReviewsOne(t_idx);
		Map map=reviewService.getPagingReviewList(t_idx, nowPage, search, search_text);
		model.addAttribute("map", map);
		
		return "_jsp/review/review_list";
	}

}
