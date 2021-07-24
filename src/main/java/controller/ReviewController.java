package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReviewDao;
import vo.ReviewVo;

@Controller
@RequestMapping("/review/")
public class ReviewController {
	
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	ReviewDao reviewDao;

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@RequestMapping("reviewinsert")
	public String insert(ReviewVo vo) {
		int insert=reviewDao.insert(vo);
		return "redirect:_jsp/talent/talentdetail.do";
	}
	
	@RequestMapping("reviewselectone")
	@ResponseBody
	public String getReviewsforonetalent(Model model,int t_id) {
		List<ReviewVo> reviewlist=reviewDao.getReviewsForOne(t_id);
		model.addAttribute("list",reviewlist);
		return "redirect:_jsp/talent/talentdetail.do";
	}
}
