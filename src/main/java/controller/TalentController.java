package controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.TalentService;
import vo.TalentVo;
import vo.MemberVo;

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
		//request param,필수로 넘겨주지 않아도 되는 nowPage, search,search_text parmater로 받는다.
		Map map = talentService.getPagingTalentList(nowPage, search, search_text);
		model.addAttribute("map", map);
		return "_jsp/talent/talent_list";
	}

	// view 매칭
	@RequestMapping("talentdetail.do")
	public String talentDetail(int t_idx, Model model) {
		//재능 상세페이지 view
		TalentVo vo = talentService.getTalentOne(t_idx);
		model.addAttribute("talentvo", vo);
		session.setAttribute("tvo", vo);
		return "_jsp/talent/talent_detail";
	}

	// view 매칭
	@RequestMapping("inserttalent.do")
	public String TalentWrite() {
		//talent 등록 페이지 view
		return "_jsp/talent/talent_register";
	}

	@RequestMapping("talentinsert")
	public String insertTalentVo(TalentVo vo, @RequestParam MultipartFile image, Model model) throws Exception {
		//로그인 확인 비로그인시 login form으로 이동하고 로그인시 insert 후 재능 목록으로 이동
		MemberVo user = (MemberVo) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}
		try {
			talentService.insertTalent(vo, image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:talentlist.do";
	}

	@RequestMapping("updatestar")
	public String modify(int t_idx) {
		//t_idx에 해당하는 talent의 starscore를 update하고 다시 t_idx에 해당하는 상세 페이지로 이동 
		try {
			talentService.updateTalentStar(t_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:talentdetail.do?t_idx=" + t_idx;
	}

	@RequestMapping("delete.do")
	public String delete(int t_idx) {
		//talent delete 이후 재능 목록으로 다시 이동
		try {
			int res = talentService.deleteTalent(t_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:talentlist.do";
	}

	// 수정 폼 view 매칭
	@RequestMapping("modify_form.do")
	public String modify_form(int t_idx, Model model) {

		TalentVo vo = talentService.getTalentOne(t_idx);
		model.addAttribute("vo", vo);

		return "_jsp/talent/talent_modify";
	}

	// 수정기능
	@RequestMapping("modify.do")
	public String modify(TalentVo vo, Model model) {
		//로그인 확인 비로그인시 로그인 창으로 이동, 로그인시 talent update 하고 talent 상세페이지로 이동
		//TODO 상세 페이지로 이동 수정 필요
		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}
		// DB update
		try {
			int res = talentService.updateTalent(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("t_idx", vo.getT_idx());
		return "talentdetail.do"; // view.do?t_idx=5
	}
}
