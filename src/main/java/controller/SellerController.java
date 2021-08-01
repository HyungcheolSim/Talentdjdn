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

import dao.SellerDao;
import mycommon.MyConstant;
import util.Paging;
import vo.BoardVo;
import vo.MemberVo;
import vo.SellerVo;

@Controller
@RequestMapping("/seller/")
public class SellerController {
	
	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext application;
	
	SellerDao sellerDao;

	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}	
	
   @RequestMapping("list.do")
   public String list(@RequestParam(value="page",required=false,defaultValue="1") int nowPage, 
		   			  @RequestParam(value = "search",required = false,defaultValue = "all") String search, 
		   			  @RequestParam(value = "search_text",required = false,defaultValue = "") String search_text,
		   				Model model) { 

	  int start = (nowPage-1) * MyConstant.Seller.BLOCK_LIST + 1; 
	  int end   = start + MyConstant.Seller.BLOCK_LIST - 1; 
	   
	  Map map = new HashMap();
	  map.put("start", start);
	  map.put("end", end);
	  
	  if(search.equals("s_id")) {
		  map.put("s_id", search_text);
	  }else if(search.equals("s_field")) {
		  map.put("s_field", search_text);
	  }
      List<SellerVo> list = sellerDao.selectList(map);
	   
	  int rowTotal = sellerDao.selectRowTotal(map);
	  
	  String search_filter = String.format("&search=%s&search_text=%s", search,search_text);
	  
	  String pageMenu = Paging.getPaging("list.do", 
			                              nowPage, 
			                              rowTotal, 
			                              search_filter,
			                              MyConstant.Seller.BLOCK_LIST, 
			                              MyConstant.Seller.BLOCK_PAGE);
      
      model.addAttribute("list",list);
      model.addAttribute("pageMenu",pageMenu);
      
      return "_jsp/seller/seller_list";
   }
   
   @RequestMapping("insert_form.do")
   public String insert_form() {
      
      return "_jsp/seller/seller_insert_form";
   }
   
   @RequestMapping("insert.do")
   public String insert(SellerVo vo, Model model,@RequestParam MultipartFile potfolio) throws Exception {
         
      MemberVo user = (MemberVo) session.getAttribute("user");
      
      if(user==null) {
         
         model.addAttribute("reason","end_session");
         
         return "redirect:../member/login_form.do";
      }
      
	    String web_path = "/resources/img/";

	    String save_dir = application.getRealPath(web_path);
	    
	    String filename = "no_file";

	    if(!potfolio.isEmpty()) {
	    	
	    	filename = potfolio.getOriginalFilename();

	       File f = new File(save_dir,filename);
	          
	       while(f.exists()) { 
	               
	          long time = System.currentTimeMillis();

	          filename = String.format("%d_%s", time,filename);
	               
	          f = new File(save_dir,filename);
	       }
	          
	       vo.setS_potfolio(filename);
	          
	       potfolio.transferTo(f);
	    }

      vo.setS_id(user.getM_id());
      
      //\r\n ~> <br>
      String s_msg = vo.getS_msg().replaceAll("\r\n", "<br>");
      vo.setS_msg(s_msg);
      
      //DB Insert
      try {
         int res = sellerDao.insert(vo);
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      return "redirect:list.do";
   }
   
   @RequestMapping("view.do")
   public String view(int s_idx,Model model) {
	   
	   SellerVo vo = sellerDao.selectOne(s_idx);
	   
	   model.addAttribute("vo", vo);
	   
	   return "_jsp/seller/seller_view";
   }
   
   @RequestMapping("modify_form.do")
   public String modify_form(int s_idx,Model model) {

	   SellerVo vo = sellerDao.selectOne(s_idx);

	   String msg = vo.getS_msg().replaceAll("<br>", "\r\n");
	   vo.setS_msg(msg);
	   
	   model.addAttribute("vo", vo);
	      
	   return "_jsp/seller/seller_modify_form";
   }
   
   @RequestMapping("modify.do")
   public String modify(SellerVo vo,int page,
			  @RequestParam(value = "search",required = false,defaultValue = "all") String search, 
			  @RequestParam(value = "search_text",required = false,defaultValue = "") String search_text,
		      Model model,@RequestParam MultipartFile potfolio) throws Exception{
	   
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      
	      if(user==null) {
	         
	         model.addAttribute("reason","end_session");
	         
	         return "redirect:../member/login_form.do";
	      }
	      
	      String web_path = "/resources/img/";

		    String save_dir = application.getRealPath(web_path);
		    
		    String filename = "no_file";

		    if(!potfolio.isEmpty()) {
		    	
		    	filename = potfolio.getOriginalFilename();
		          
		       File f = new File(save_dir,filename);
		          
		       while(f.exists()) { 
		               
		          long time = System.currentTimeMillis();

		          filename = String.format("%d_%s", time,filename);
		               
		          f = new File(save_dir,filename);
		       }
		          
		       vo.setS_potfolio(filename);
		          
		       potfolio.transferTo(f);
		    } 
	      
	      vo.setS_id(user.getM_id());
	      
	      //\r\n ~> <br>
	      String s_msg = vo.getS_msg().replaceAll("\r\n", "<br>");
	      vo.setS_msg(s_msg);
	      
	      //DB update
	      try {
	         
	         int res = sellerDao.update(vo);
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	   model.addAttribute("s_idx", vo.getS_idx());
	   model.addAttribute("page", page);
	   model.addAttribute("search", search);
	   model.addAttribute("search_text", search_text);
	   
	   return"redirect:view.do"; 
   }
   
   @RequestMapping("delete.do")
   public String delete(int s_idx) {
	   
	   try {
		   
		int res = sellerDao.delete(s_idx);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return "redirect:list.do"; 
	   
   }
   
}