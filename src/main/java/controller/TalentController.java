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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import dao.TalentDao;
import mycommon.MyConstant;
import util.Paging;

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
	TalentDao talentDao;

	// Dao와 Controller의 setter를 통한 DI
	public void setTalentDao(TalentDao talentDao) {
		this.talentDao = talentDao;
	}

	@RequestMapping("talentlist.do")
	public String talent_list(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text, Model model) {

		int start = (nowPage - 1) * MyConstant.Board.BLOCK_LIST + 1;
		int end = start + MyConstant.Board.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		// �˻������� Map�� �߰�

		if (search.equals("name")) {
			map.put("name", search_text);
		} else if (search.equals("subject")) {
			map.put("subject", search_text);
		} else if (search.equals("content")) {
			map.put("content", search_text);
		} else if (search.equals("subject_content")) {
			map.put("subject", search_text);
			map.put("content", search_text);
		}

		List<TalentVo> list = talentDao.selectList(map);

		int rowTotal = talentDao.selectRowTotal(map);

		String search_filter = String.format("&search=%s&search_text=%s", search, search_text);

		String pageMenu = Paging.getPaging("talentlist.do", nowPage, rowTotal, search_filter,
				MyConstant.Board.BLOCK_LIST, MyConstant.Board.BLOCK_PAGE);

		session.removeAttribute("show");

		// model���ؼ� DispatcherServlet���� ���� => ��������� request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);

		return "_jsp/talent/talent_list";
	}

	// view 매칭
	@RequestMapping("talentdetail.do")
	public String talentDetail(int t_idx, Model model) {
		TalentVo vo = talentDao.selectOne(t_idx);
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
		// SellerVo seller =
		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}
		// if(user.getM_id().equals(SellerVo svo.))
		vo.setS_idx(user.getM_idx());
		

		String web_path = "/resources/img/";

		String save_dir = application.getRealPath(web_path);

		String filename = "no_file";

		if (!image.isEmpty()) {

			filename = image.getOriginalFilename();

			File f = new File(save_dir, filename);

			while (f.exists()) {

				long time = System.currentTimeMillis();

				filename = String.format("%d_%s", time, filename);

				f = new File(save_dir, filename);
			}

			vo.setT_image(filename);
			image.transferTo(f);
		}

		// \r\n ~> <br>
		String s_msg = vo.getT_content().replaceAll("\r\n", "<br>");
		vo.setT_content(s_msg);
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
		return "redirect:talentdetail.do?t_idx=" + t_idx;
	}

}
