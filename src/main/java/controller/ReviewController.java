package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Param;

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
//
//	@RequestMapping("insert.do")
//	@ResponseBody
//	public Map insert(ReviewVo vo) {
//		String r_content = vo.getR_content().replaceAll("\r\n", "<br>");
//		vo.setR_content(r_content);
//		int res = 0;
//		try {
//			res = reviewDao.insert(vo);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Map map = new HashMap();
//
//		map.put("result", (res == 1) ? "success" : "fail"); // { "result" : "success" }
//		return map;
//	}
//
//	@RequestMapping("list.do")
//	public String list(int t_id, Model model) {
//
//		List<ReviewVo> list = reviewDao.getReviewsForOne(t_id);
//
//		model.addAttribute("reviewlist", list);
//
//		return "redirect:../talent/talentdetail.do?t_id=" + t_id;
//	}
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
		vo.setT_idx(TID);
		// DB Insert
		try {
			int insert = reviewDao.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../talent/talentdetail.do?t_id="+TID;
	}

	@RequestMapping("reviewselectone")
	public String getReviewsforonetalent(int t_idx,Model model) {
		List<ReviewVo> reviewlist = reviewDao.getReviewsForOne(t_idx);
		
		model.addAttribute("reviewlist", reviewlist);
		
		return "forward:../talent/talentdetail.do?t_id="+t_idx;
	}


}
