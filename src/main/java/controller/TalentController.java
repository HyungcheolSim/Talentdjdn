package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import dao.TalentDao;
import mycommon.MyConstant;
import service.TalentService;
import util.Paging;
import util.UploadFileUtils;
import vo.TalentVo;
import vo.MemberVo;
import vo.TalentVo;

@Controller
@RequestMapping("/talent/")
public class TalentController {
	// 화면과 매칭 + 전달할 정보 포함
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request;

	@Autowired
	TalentService talentService;

	public void setTalentService(TalentService talentService) {
		this.talentService = talentService;
	}

	@RequestMapping("talentlist.do")
	public String talent_list(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text, Model model) {
		
		Map map = talentService.getPagingTalentList(nowPage, search, search_text);
		
		session.removeAttribute("show");

		model.addAttribute("map", map);

		return "_jsp/talent/talent_list";
	}

	// view 매칭
	@RequestMapping("talentdetail.do")
	public String talentDetail(int t_idx, Model model) {
		TalentVo vo = talentService.getTalentOne(t_idx);
		model.addAttribute("talentvo", vo);
		session.setAttribute("tvo", vo);
		return "_jsp/talent/talent_detail";
	}

	// view 매칭
	@RequestMapping("inserttalent.do")
	public String TalentWrite() {
		return "_jsp/talent/talent_register";
	}

	@RequestMapping("talentinsert")
	public String insertTalentVo(TalentVo vo, @RequestParam MultipartFile image, Model model) throws Exception {
		MemberVo user = (MemberVo) session.getAttribute("user");
		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}
		

		try {
			talentService.insertTalent(vo, image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:talentlist.do";
	}

	@RequestMapping("updatestar")
	public String modify(int t_idx) {
		try {
			talentService.updateTalentStar(t_idx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:talentdetail.do?t_idx=" + t_idx;
	}

	@RequestMapping("delete.do")
	public String delete(int t_idx) {

		try {

			int res = talentService.deleteTalent(t_idx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:talentlist.do";

	}

	// �닔�젙�뤌 �쓣�슦湲�
	@RequestMapping("modify_form.do")
	public String modify_form(int t_idx, Model model) {

		TalentVo vo = talentService.getTalentOne(t_idx);
		model.addAttribute("vo", vo);

		return "_jsp/talent/talent_modify";
	}

	// �닔�젙�븯湲�
	@RequestMapping("modify.do")
	public String modify(TalentVo vo, Model model) {

		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}

		// DB update
		try {
			
			int res = talentService.updateTalent(vo);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("t_idx", vo.getT_idx());
		return "talentdetail.do"; // view.do?t_idx=5
	}
}
