package controller;

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


	@RequestMapping("list.do")
	public String list(Model model) {
		//session에 들어있는 membervo로 들어가는 user 정보를 가져와 m_idx에 해당하는 interstlist 조회하고 list page로 이동
		MemberVo user =  (MemberVo) session.getAttribute("user");
		List<InterestVo> list = interestService.selectList(user.getM_idx());
		
		model.addAttribute("list",list);
		
		return "_jsp/interest/interest_list";

	}
	
	@ResponseBody
	@RequestMapping("deletelist.do")
	public int delete(@RequestParam(value="chbox[]")List<String> chArr) {
		//체크목록 전체삭제같은 기능을 위한 삭제 기능. chArr이란 string list에 담아 list size만큼 반복하며 해당하는 i_idx를 삭제
		int result=0;
		int pNum=0;
		for(String i:chArr) {
			pNum=Integer.parseInt(i);			
			interestService.deleteInterest(pNum);
			result=1;
		}
		return result;
	}
	
	@RequestMapping("insert.do")
	@ResponseBody
	public Map insert(InterestVo vo) {
		//관심목록 등록
		Map map = interestService.insert(vo);
		return map;
	}
	
	
}
