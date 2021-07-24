package controller;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TalentService;
import vo.TalentVo;

@Controller
@RequestMapping("/talent/")
public class TalentController {
	//화면과 매칭 + 전달할 정보 포함
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	TalentService talentService;

	//Dao와 Controller의 setter를 통한 DI
//	public void setTalentDao(TalentDao talentDao) {
//		this.talentDao = talentDao;
//	}
	public void setTalentService(TalentService talentService) {
		this.talentService=talentService;
	}
	//Service와 Controller의 setter를 통한 DI
	

	//view 매칭
	@RequestMapping("talentlist.do")
	public String getTalentList() {
		
		return "_jsp/talent/talent_list";
	}
	
	//데이터 전송
	@RequestMapping("gettalentlist.do")
	@ResponseBody
	public List<TalentVo> getTalentLists(){
		List<TalentVo> talentList=talentService.selectTalentList();
		return talentList;
	}

	//view 매칭
	@RequestMapping("talentdetail.do")
	public String talentDetail() {
		return "_jsp/talent/talent_detail";
	}
	
	//데이터 전송
	@RequestMapping("onetalent")
	@ResponseBody
	public TalentVo getOneTalentById(int t_id) {
		TalentVo tv=talentService.selectOneTalent(t_id);
		return tv;
	}
	//view 매칭
	@RequestMapping("inserttalent.do")
	public String TalentWrite() {
		return "_jsp/talent/talent_register";
	}
	//데이터 전송 기능하지않음..
	@RequestMapping("talentinsert")
	public String insertTalentVo(TalentVo vo) {
		talentService.insertTalent(vo);
		return "redirect:talentlist.do";
	}


}
