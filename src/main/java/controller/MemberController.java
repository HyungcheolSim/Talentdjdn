package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDao;
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


	@RequestMapping("login_form.do")
	public String login_form() {
		
		return "_jsp/member/login";
	}
	
	
	@RequestMapping("login.do")

	public String login(String m_id,String url,String m_pwd,Model model) {

		MemberVo user = memberService.getMemberOne(m_id);
		  
		if(user==null) { 
		 
			
			model.addAttribute("reason", "fail_id");
			
			return "redirect:login_form.do";
		}
		  
		//��й�ȣ ��
		if(user.getM_pwd().equals(m_pwd)==false) {
		     
			
			model.addAttribute("reason", "fail_pwd");
			
			return "redirect:login_form.do";
		}
		
		//�������� �α��λ���
		//���� user�� ����Ҽ� �ִ� session���� ���ϱ�
		session.setAttribute("user", user);
		
		if(url==null) url="";
		
		if(url.isEmpty())
			return "redirect:../main/index.do";
		else
			return "redirect:" + url;
		
	}
	
	
	//�α׾ƿ�
	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		return "redirect:../main/index.do";
	}
	
	//ȸ������
	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {
		
		//5. DB insert
		int res = memberService.insertMember(vo);
		
		return "redirect:login_form.do";
	}
	
	//���̵�üũ
	@RequestMapping("check_id.do")
	@ResponseBody
	public Map check_id(String m_id) {
	      Map map=memberService.checkMemberId(m_id);
	     return map;
	}
	
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		return "_jsp/member/join_page";
	}
	
	   @RequestMapping("modify_form.do")
	   public String modify_form(int m_idx,Model model) {
		   	
			  MemberVo vo = memberService.getMemberOne(m_idx);
			  
			  model.addAttribute("vo", vo);
				   
		   return "_jsp/member/modify_form";
	   }
	   

	   @RequestMapping("modify.do")
		public String modify(MemberVo vo) {
			
			int res = memberService.updateMember(vo);

			return "redirect:../main/index.do";
		}
	
}
