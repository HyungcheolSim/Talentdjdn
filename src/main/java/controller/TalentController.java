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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.TalentDao;
import mycommon.MyConstant;
import util.Paging;
import vo.BoardVo;
import vo.MemberVo;
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
	TalentDao talentDao;

	//Dao와 Controller의 setter를 통한 DI
	public void setTalentDao(TalentDao talentDao) {
		this.talentDao = talentDao;
	}

	


//	@RequestMapping("talentlist.do")
//	public String getTalentList(Model model) {
//		List<TalentVo> list = talentDao.getTalentList();
//		model.addAttribute("list",list);		
//		return "_jsp/talent/talent_list";
//	}
	@RequestMapping("talentlist.do")
	public String talent_list(@RequestParam(value="page",required=false,defaultValue="1") int nowPage, 
 			  @RequestParam(value = "search",required = false,defaultValue = "all") String search, 
 			  @RequestParam(value = "search_text",required = false,defaultValue = "") String search_text,
 				Model model) {
		
		  int start = (nowPage-1) * MyConstant.Board.BLOCK_LIST + 1; 
		  int end   = start + MyConstant.Board.BLOCK_LIST - 1; 
		   
		  Map map = new HashMap();
		  map.put("start", start);
		  map.put("end", end);
		  
		  //�˻������� Map�� �߰�
		  
		  if(search.equals("name")) {
			  map.put("name", search_text);
		  }else if(search.equals("subject")) {
			  map.put("subject", search_text);
		  }else if(search.equals("content")) {
			  map.put("content", search_text);
		  }else if(search.equals("subject_content")) {
			  map.put("subject", search_text);
			  map.put("content", search_text);
		  }  
		  
	      List<TalentVo> list = talentDao.selectList(map);
		   
		  //�˻� ���ǿ� ���� �Խù��� ���ϱ�
		  int rowTotal = talentDao.selectRowTotal(map);
	      
		  //System.out.println(rowTotal);
		  
		  //PagingMenu �����...
		  
		  //list.do?page=1&search=all&search_text=
		  
		  String search_filter = String.format("&search=%s&search_text=%s", search,search_text);
		  
		  String pageMenu = Paging.getPaging("talentlist.do", 
				                              nowPage, 
				                              rowTotal, 
				                              search_filter,
				                              MyConstant.Board.BLOCK_LIST, 
				                              MyConstant.Board.BLOCK_PAGE);
	      
	      //view.do���� �ó�?�� ���� ���� ����� ���� �� => ����
	      session.removeAttribute("show");
	      
	      //model���ؼ� DispatcherServlet���� ���� => ��������� request binding
	      model.addAttribute("list",list);
	      model.addAttribute("pageMenu",pageMenu);
		
		return "_jsp/talent/talent_list"; 
	}


	
	
	//view 매칭
	@RequestMapping("talentdetail.do")
	public String talentDetail(int t_idx,Model model) {
		TalentVo vo=talentDao.selectOne(t_idx);
		model.addAttribute("talentvo",vo);
		session.setAttribute("tvo", vo);
		return "_jsp/talent/talent_detail";
	}
	
	//view 매칭
	@RequestMapping("inserttalent.do")
	public String TalentWrite() {
		return "_jsp/talent/talent_register";
	}

	
	@RequestMapping("talentinsert")
	public String insertTalentVo(TalentVo vo, Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");
		  
		if(user==null) {
	     
	    model.addAttribute("reason","end_session");
	     
	    return "redirect:../member/login_form.do";
		}
		vo.setS_id(user.getM_id());
		vo.setS_idx(user.getM_idx());
		try {
			talentDao.insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:talentlist.do";
	}
	
	
	
	@RequestMapping("updatestar")
	public String modify(int t_idx) {
		try {
			talentDao.updateStar(t_idx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:talentdetail.do?t_idx="+t_idx;
	}


}
