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
import dao.ReviewDao;
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

	ReviewDao reviewDao;

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@RequestMapping("reviewinsert")
	public String insert(ReviewVo vo, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}
		vo.setM_idx(user.getM_idx());
		TalentVo tvo=(TalentVo)session.getAttribute("tvo");
		Integer TID=tvo.getT_idx();
		vo.setT_idx(TID);
		// DB Insert
		try {
			int insert = reviewDao.insert(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../talent/talentdetail.do?t_idx="+TID;
		
	}

	@RequestMapping("reviewselectone")
	public String getReviewsforonetalent(int t_idx,Model model) {
		List<ReviewVo> reviewlist = reviewDao.getReviewsForOne(t_idx);
		
		model.addAttribute("reviewlist", reviewlist);
		
		return "redirect:../talent/talentdetail.do?t_idx="+t_idx;
	}


}
