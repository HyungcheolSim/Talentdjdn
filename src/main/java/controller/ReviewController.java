package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ReviewDao;
import dao.TalentDao;
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
	TalentDao talentDao;

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	public void setTalentDao(TalentDao talentDao) {
		this.talentDao=talentDao;
	}

	@RequestMapping("reviewinsert")
	public String insert(ReviewVo vo, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}
		vo.setM_id(user.getM_id());
		TalentVo tvo=(TalentVo)session.getAttribute("tvo");
		Integer TID=tvo.getT_id();
		vo.setT_id(TID);
		// DB Insert
		try {
			int insert = reviewDao.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../talent/talentdetail.do?t_id="+TID;
	}

	@RequestMapping("reviewselectone")
	@ResponseBody
	public String getReviewsforonetalent(int t_id,Model model) {
		TalentVo vo=talentDao.selectOne(t_id);
		int talentID=vo.getT_id();
		List<ReviewVo> reviewlist = reviewDao.getReviewsForOne(talentID);
		
		model.addAttribute("reviewlist", reviewlist);
		
		return "redirect:_jsp/talent/talentdetail.do?t_id="+talentID;
	}
	
	
}
