package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.InterestService;
import vo.InterestVo;
import vo.MemberVo;

@Controller
@RequestMapping("/interest/")
public class InterestController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	InterestService interestService;

	public void setInterestService(InterestService interestService) {
		this.interestService = interestService;
	}

	// ����ʹ� ��� ��ȸ
	@RequestMapping("list.do")
	public String list(Model model) {
		
		MemberVo user =  (MemberVo) session.getAttribute("user");

		List<InterestVo> list = interestService.selectList(user.getM_idx());
		
		model.addAttribute("list",list);
		
		return "_jsp/interest/interest_list";

	}
	
	// ����ʹ� ����
	@RequestMapping("delete.do")
	@ResponseBody
	public Map delete(int t_idx) {
		
		Map map = interestService.delete(t_idx);

		return map;
	}
	
	// ����ʹ� �߰�
	@RequestMapping("insert.do")
	@ResponseBody
	public Map insert(InterestVo vo) {	
		
		Map map = interestService.insert(vo);
		
		return map;
	}
	
	
}
