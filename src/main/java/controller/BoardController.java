package controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.BoardService;
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
		//map에 service에서 받아온 map 객체를 받아 model로 view에 전달 후 board list 페이지로 이동
		Map map=boardService.getPagingBoardList(nowPage,search,search_text);

		model.addAttribute("map", map);

		return "_jsp/board/board_list";
	}

	@RequestMapping("insert_form.do")
	public String insert_form() {
		//입력폼으로 이동~
		return "_jsp/board/board_insert_form";
	}

	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {
		//게시판(공지사항) 로그인 여부 확인 후 등록 후 board list로 이동
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
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

	@RequestMapping("view.do")
	public String view(int b_idx, Model model) {
		//TODO 확인 필요 getone board 이후 왜 updateboardreadhit?
		BoardVo vo = boardService.getOneBoard(b_idx);
		try {
			int res = boardService.updateBoardReadHit(b_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("vo", vo);

		return "_jsp/board/board_view";
	}

	@RequestMapping("delete.do")
	public String delete(int b_idx) {
		//board 삭제 후 board list로 이동
		try {
			int res = boardService.deleteBoard(b_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}


	@RequestMapping("modify_form.do")
	public String modify_form(int b_idx, Model model) {
		//b_idx에 해당하는 boardvo 가져온 후 해당 vo의 수정 폼으로 이동
		BoardVo vo = boardService.getOneBoard(b_idx);
		model.addAttribute("vo", vo);

		return "_jsp/board/board_modify_form";
	}

	@RequestMapping("modify.do")
	public String modify(BoardVo vo, Model model) {
		//세션에서 member 정보 가져온 후 boardupdate 한 후 view로 이동
		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}

		vo.setM_id(user.getM_id());
		vo.setM_grade(user.getM_grade());

		try {
			int res = boardService.updateBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("b_idx", vo.getB_idx());

		return "redirect:view.do"; // view.do?b_idx=5
	}

}
