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
import vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//����������
	@RequestMapping("list.do")
	public String index() {
		
		return "_jsp/index";
	}
	
	//�α����� ����
	@RequestMapping("login_form.do")
	public String login_form() {
		
		return "_jsp/member/login";
	}
	
	
	//�α���
	@RequestMapping("login.do")
	public String login(String m_id,String m_pwd,Model model) {
	
		//�޼ҵ��� ����? �ǹ�? : DispatcherServlet�� ���� ��û����
		//Model �뵵?
		//�� 1. forward�ÿ��� request binding��Ų��
		//   2. redirect�ÿ��� parameter����(query)�� �̿�ȴ�
		
		//3.m_id�� �ش�Ǵ� MemberVo 1�� ������
		MemberVo user = memberDao.selectOne(m_id);
		  
		if(user==null) { //ID�� ���°��
		 
			//return "redirect:login_form.do?reason=fail_id";
			
			model.addAttribute("reason", "fail_id");
			
			return "redirect:login_form.do";
		}
		  
		//��й�ȣ ��
		if(user.getM_pwd().equals(m_pwd)==false) {
		     
			//return "redirect:login_form.do?reason=fail_pwd";
			
			model.addAttribute("reason", "fail_pwd");
			
			return "redirect:login_form.do";
		}
		
		//�������� �α��λ���
		//���� user�� ����Ҽ� �ִ� session���� ���ϱ�
		session.setAttribute("user", user);
		
		//�������� �̵�
		return "redirect:list.do";
	}
	
	
	//�α׾ƿ�
	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		return "redirect:list.do";
	}
	
	//ȸ������
	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {
		
		//5. DB insert
		int res = memberDao.insert(vo);
		
		return "redirect:login_form.do";
	}
	
	//���̵�üũ
	@RequestMapping("check_id.do")
	@ResponseBody
	public Map check_id(String m_id) {
	      
	      Map map = new HashMap();
	      
	      //DB���� m_id���翩�� �˻� 
	      boolean bResult;
	      MemberVo vo = memberDao.selectOne(m_id);
	         
	      if(vo==null) {//��밡���� ID
	         bResult = true;
	      }else {
	         //������� ID
	         bResult = false; 
	      }
	      
	      map.put("result", bResult);
	      
	      return map;
	}
	
	
	//ȸ������ �Է��� ����
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		return "_jsp/member/join_page";
	}
}
