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

import dao.BoardDao;
import mycommon.MyConstant;
import util.Paging;
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
	
	//寃뚯떆�뙋 紐⑸줉蹂닿린
	@RequestMapping("list.do")
	public String board_list(@RequestParam(value="page",required=false,defaultValue="1") int nowPage, 
 			  @RequestParam(value = "search",required = false,defaultValue = "all") String search, 
 			  @RequestParam(value = "search_text",required = false,defaultValue = "") String search_text,
 				Model model) {
		
	      
		  //占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 : nowPage
		   
		  //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
		  int start = (nowPage-1) * MyConstant.Board.BLOCK_LIST + 1; 
		  int end   = start + MyConstant.Board.BLOCK_LIST - 1; 
		   
		  Map map = new HashMap();
		  map.put("start", start);
		  map.put("end", end);
		  
		  //占싯삼옙占쏙옙占쏙옙占쏙옙 Map占쏙옙 占쌩곤옙
		  
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
		  
	      List<BoardVo> list = boardDao.selectList(map);
		   
		  //占싯삼옙 占쏙옙占실울옙 占쏙옙占쏙옙 占쌉시뱄옙占쏙옙 占쏙옙占싹깍옙
		  int rowTotal = boardDao.selectRowTotal(map);
	      
		  //System.out.println(rowTotal);
		  
		  //PagingMenu 占쏙옙占쏙옙占�...
		  
		  //list.do?page=1&search=all&search_text=
		  
		  String search_filter = String.format("&search=%s&search_text=%s", search,search_text);
		  
		  String pageMenu = Paging.getPaging("list.do", 
				                              nowPage, 
				                              rowTotal, 
				                              search_filter,
				                              MyConstant.Board.BLOCK_LIST, 
				                              MyConstant.Board.BLOCK_PAGE);
	      
	      //view.do占쏙옙占쏙옙 占시놂옙?占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙 => 占쏙옙占쏙옙
	      session.removeAttribute("show");
	      
	      //model占쏙옙占쌔쇽옙 DispatcherServlet占쏙옙占쏙옙 占쏙옙占쏙옙 => 占쏙옙占쏙옙占쏙옙占쏙옙占� request binding
	      model.addAttribute("list",list);
	      model.addAttribute("pageMenu",pageMenu);
		
		return "_jsp/board/board_list"; 
	}
	
	//湲��벐湲고뤌
	@RequestMapping("insert_form.do")
	public String insert_form() {
	      
	   return "_jsp/board/board_insert_form";
	}
	
	//湲��벐湲�
	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {
	      
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      
	      if(user==null) {
	         
	         model.addAttribute("reason","end_session");
	         
	         return "redirect:../member/login_form.do";
	      }
	      
	      vo.setM_idx(user.getM_idx());
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
	
	   //寃뚯떆�뙋 �뤌蹂닿린
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
	   
	   //寃뚯떆臾� �궘�젣
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
	   
	   //�닔�젙�뤌 �쓣�슦湲�
	   @RequestMapping("modify_form.do")
	   public String modify_form(int b_idx,Model model) {
		   
		   BoardVo vo = boardDao.selectOne(b_idx);
		   
		   String content = vo.getB_content().replaceAll("<br>", "\r\n");
		   vo.setB_content(content);
		   
		   model.addAttribute("vo", vo);
		   	   
		   return "_jsp/board/board_modify_form";
	   }
	   
	   //�닔�젙�븯湲�
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
