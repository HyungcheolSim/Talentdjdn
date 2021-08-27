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

import service.MemberService;
import vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	MemberService memberService;
	
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("list.do")
	
	public String member_list(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			                 Model model){
		//페이징 기능만 있는 멤버 목록 조회 후 model로 map 전달한 후 멤버목록 리턴
		Map map = memberService.getPagingMemberList(nowPage);
		
		model.addAttribute("map", map);
		
		return "_jsp/member/member_list";
	}
	
	@RequestMapping("login_form.do")
	public String login_form() {
		//로그인 폼 view 매칭
		return "_jsp/member/login";
	}
	
	@RequestMapping("login.do")
	public String login(String m_id,String url,String m_pwd,Model model) {
		//로그인 기능 로그인 체크 후 로그인 전 url이 있으면 다시 이동하고 없으면 메인 화면으로 이동
		MemberVo user = memberService.getMemberOne(m_id);
		  
		if(user==null) { 
			model.addAttribute("reason", "fail_id");
			
			return "redirect:login_form.do";
		}
		  
		if(user.getM_pwd().equals(m_pwd)==false) {
			model.addAttribute("reason", "fail_pwd");
			return "redirect:login_form.do";
		}
		
		session.setAttribute("user", user);
		if(url==null) url="";
		if(url.isEmpty())
			return "redirect:../main/index.do";
		else
			return "redirect:" + url;
	}

	@RequestMapping("logout.do")
	public String logout() {
		//로그아웃 기능 세션 삭제하고 메인화면으로 이동!
		session.removeAttribute("user");
		return "redirect:../main/index.do";
	}
	
	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {
		//5. DB insert 후 로그인 폼으로 이동
		int res = memberService.insertMember(vo);
		return "redirect:login_form.do";
	}
	
	@RequestMapping("check_id.do")
	@ResponseBody
	public Map check_id(String m_id) {
		//로그인 확인한 결과 map으로 받아 리턴
	      Map map=memberService.checkMemberId(m_id);
	     return map;
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		//회원등록 화면 view 매칭
		return "_jsp/member/join_page";
	}
	
	@RequestMapping("member_info_form.do")
	   public String member_info_form(int m_idx,Model model) {
		   	//마이페이지 service에서 멤버정보와 멤버에 해당하는 seller 목록 불러와 model로 전달한 후 마이페이지(멤버 상세)로 이동
			  MemberVo vo = memberService.getMemberOne(m_idx);
			  
			  List list = memberService.getSellerList(m_idx);
			  
			  model.addAttribute("vo", vo);
			  model.addAttribute("list", list);
				   
		   return "_jsp/member/member_info";
	   }	
	
	   @RequestMapping("modify_form.do")
	   public String modify_form(int m_idx,Model model) {
		   	//멤버 수정 폼 m_idx에 해당하는 vo 가져오고 수정폼으로 이동
			  MemberVo vo = memberService.getMemberOne(m_idx);
			  
			  model.addAttribute("vo", vo);
				   
		   return "_jsp/member/modify_form";
	   }
	   
	   @RequestMapping("modify.do")
		public String modify(MemberVo vo) {
		   //멤버 수정 후 메인 화면으로 이동
			int res = memberService.updateMember(vo);
			return "redirect:../main/index.do";
		}
	   
		@RequestMapping("delete.do")
		public String delete(int m_idx) {
			// 멤버 삭제 후 목록으로 이동
			int res = memberService.delete(m_idx);
			return "redirect:list.do";
		}
}
