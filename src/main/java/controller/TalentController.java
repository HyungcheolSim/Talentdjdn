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

import dao.TalentDao;
import vo.TalentVo;

@Controller
@RequestMapping("/talent/")
public class TalentController {
	//화면과 매칭 + 전달할 정보 포함
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	TalentDao talentDao;

	//setter를 통한 DI
	public void setTalentDao(TalentDao talentDao) {
		this.talentDao = talentDao;
	}
	
	//
	@RequestMapping("list.do")
	public String index() {
		
		return "_jsp/index";
	}
	
	@RequestMapping("login_form.do")
	public String login_form() {
		
		return "_jsp/talent/login";
	}


	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		return "redirect:list.do";
	}
	

	@RequestMapping("insert.do")
	public String insert(TalentVo vo) {
		
		//5. DB insert
		int res = talentDao.insert(vo);
		
		return "redirect:login_form.do";
	}
	

	@RequestMapping("check_id.do")
	@ResponseBody
	public Map check_id(int s_id) {
	      
	      Map map = new HashMap();
	      

	      boolean bResult;
	      TalentVo vo = talentDao.selectOne(s_id);
	         
	      if(vo==null) {
	         bResult = true;
	      }else {

	         bResult = false; 
	      }
	      
	      map.put("result", bResult);
	      
	      return map;
	}
	
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		
		return "_jsp/talent/join_page";
	}
}
