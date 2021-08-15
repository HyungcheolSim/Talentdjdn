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

import service.BoardService;
import mycommon.MyConstant;
import util.Paging;
import vo.BoardVo;
import vo.MemberVo;

@Controller
@RequestMapping("/board/")
public class BoardController {

	BoardService boardService;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("list.do")
	public String board_list(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text, Model model) {

		Map map=boardService.getPagingBoardList(nowPage,search,search_text);
		
		

		model.addAttribute("map", map);

		return "_jsp/board/board_list";
	}

	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "_jsp/board/board_insert_form";
	}

	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {

		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}

		vo.setM_idx(user.getM_idx());
		vo.setM_grade(user.getM_grade());

		// DB Insert
		try {

			int res = boardService.insertBoard(vo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list.do";
	}

	// /board/view.do?b_idx=1
	@RequestMapping("view.do")
	public String view(int b_idx, Model model) {

		BoardVo vo = boardService.getOneBoardAndUpdateReadHit(b_idx);



		model.addAttribute("vo", vo);

		return "_jsp/board/board_view";
	}

	// 寃뚯떆臾� �궘�젣
	@RequestMapping("delete.do")
	public String delete(int b_idx) {

		try {

			int res = boardService.deleteBoard(b_idx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list.do";

	}

	// �닔�젙�뤌 �쓣�슦湲�
	@RequestMapping("modify_form.do")
	public String modify_form(int b_idx, Model model) {

		BoardVo vo = boardService.getOneBoard(b_idx);
		model.addAttribute("vo", vo);

		return "_jsp/board/board_modify_form";
	}

	// �닔�젙�븯湲�
	@RequestMapping("modify.do")
	public String modify(BoardVo vo, Model model) {

		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}

		vo.setM_id(user.getM_id());
		vo.setM_grade(user.getM_grade());

		// DB update
		try {

			int res = boardService.updateBoard(vo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("b_idx", vo.getB_idx());

		return "redirect:view.do"; // view.do?b_idx=5
	}

}
