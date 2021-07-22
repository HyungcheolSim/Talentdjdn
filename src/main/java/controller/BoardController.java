package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BoardDao;
import vo.BoardVo;
import vo.MemberVo;

@Controller
@RequestMapping("/board/")
public class BoardController {

	BoardDao boardDao;
	
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	//게시판 목록보기
	@RequestMapping("list.do")
	public String board_list(Model model) {
		
		List<BoardVo> list = boardDao.selectList();
		
		model.addAttribute("list",list);
		
		return "_jsp/board/board_list"; 
	}
	
	//글쓰기폼
	@RequestMapping("insert_form.do")
	public String insert_form() {
	      
	   return "_jsp/board/board_insert_form";
	}
	
	//글쓰기
	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {
	      
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      
	      if(user==null) {
	         
	         model.addAttribute("reason","end_session");
	         
	         return "redirect:../member/login_form.do";
	      }
	      
	      vo.setM_id(user.getM_id());
	      vo.setM_grade(user.getM_grade());
	      
	      //\r\n ~> <br>
	      String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
	      vo.setB_content(b_content);
	      
	      //DB Insert
	      try {
	         
	         int res = boardDao.insert(vo);
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return "redirect:list.do";
	   }
	
	   //게시판 폼보기
	   // /board/view.do?b_idx=1
	   @RequestMapping("view.do")
	   public String view(int b_idx,Model model) {
		   
		   BoardVo vo = boardDao.selectOne(b_idx);

		   try {
			   
			if(session.getAttribute("show")==null) {

				int res = boardDao.update_readhit(b_idx); 
				
				session.setAttribute("show", true);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   model.addAttribute("vo", vo);
		   
		   return "_jsp/board/board_view";
	   }
	   
	   //게시물 삭제
	   @RequestMapping("delete.do")
	   public String delete(int b_idx) {
		   
		   try {
			   
			int res = boardDao.delete(b_idx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return "redirect:list.do"; 
		   
	   }
	   
	   //수정폼 띄우기
	   @RequestMapping("modify_form.do")
	   public String modify_form(int b_idx,Model model) {
		   
		   BoardVo vo = boardDao.selectOne(b_idx);
		   
		   String content = vo.getB_content().replaceAll("<br>", "\r\n");
		   vo.setB_content(content);
		   
		   model.addAttribute("vo", vo);
		   	   
		   return "_jsp/board/board_modify_form";
	   }
	   
	   //수정하기
	   @RequestMapping("modify.do")
	   public String modify(BoardVo vo,Model model) {
		   
		      MemberVo user = (MemberVo) session.getAttribute("user");

		      if(user==null) {
		         
		         model.addAttribute("reason","end_session");
		         
		         return "redirect:../member/login_form.do";
		      }

		      vo.setM_id(user.getM_id());
		      vo.setM_grade(user.getM_grade());
		      
		      //\r\n ~> <br>
		      String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
		      vo.setB_content(b_content);
		      
		      //DB update
		      try {
		         
		         int res = boardDao.update(vo);
		         
		      } catch (Exception e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      
		   model.addAttribute("b_idx", vo.getB_idx());
		   
		   return"redirect:view.do"; // view.do?b_idx=5
	   }
	      
}
