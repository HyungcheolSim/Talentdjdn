package controller;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.util.IOUtils;

import dao.SellerDao;

import mycommon.MyConstant;
import service.SellerService;
import util.Paging;
import util.S3Util;
import util.UploadFileUtils;
import vo.MemberVo;
import vo.SellerVo;
import vo.ThumbVo;

@Controller
@RequestMapping("/seller/")
public class SellerController {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ServletContext application;

	SellerService sellerService;

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	S3Util s3 = new S3Util();
	String bucketName = "talentdjdnbucket";


	@RequestMapping("list.do")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search_text1", required = false, defaultValue = "") String search_text1,
			@RequestParam(value = "search_text2", required = false, defaultValue = "") String search_text2, Model model,
			ThumbVo vo) {

		Map map= sellerService.getPagingSellerList(nowPage, search_text1, search_text2);
		model.addAttribute("map",map);
		return "_jsp/seller/seller_list";
	}

	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "_jsp/seller/seller_insert_form";
	}

	@RequestMapping(value="insert.do",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String insert(SellerVo vo, Model model, @RequestParam MultipartFile potfolio) throws Exception {

		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}

		// DB Insert
		vo.setS_id(user.getM_id());
		try {
			int res = sellerService.insertSeller(vo,potfolio);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list.do";
	}

	@RequestMapping("view.do")
	public String view(int s_idx, Model model) {

		SellerVo vo = sellerService.getSellerOne(s_idx);

		model.addAttribute("vo", vo);

		return "_jsp/seller/seller_view";
	}

	@RequestMapping("modify_form.do")
	public String modify_form(int s_idx, Model model) {

		SellerVo vo = sellerService.getSellerOne(s_idx);
		//vo=sellerService.getSellerOne(vo);

		model.addAttribute("vo", vo);

		return "_jsp/seller/seller_modify_form";
	}

	@RequestMapping("modify.do")
	public String modify(SellerVo vo, int page,
			@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text, Model model) throws Exception {

		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}

		vo.setS_id(user.getM_id());
		
		// DB update
		try {

			int res = sellerService.updateSeller(vo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("s_idx", vo.getS_idx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);

		return "redirect:view.do";
	}

	@RequestMapping("delete.do")
	public String delete(int s_idx) {

		try {

			int res = sellerService.deleteSeller(s_idx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:list.do";

	}

	@RequestMapping("thumb_insert.do")
	@ResponseBody
	public Map thumb_insert(ThumbVo vo) {

		return sellerService.insertThumb(vo);
	}

	@SuppressWarnings("resource")
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName, String directory) throws Exception {
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		HttpURLConnection uCon = null;

		String inputDirectory = null;
		if(directory.equals("seller")) {
			inputDirectory = "img/seller";
		}
		else if(directory.equals("talent")) {
			inputDirectory = "img/talent";
		}else if(directory.equals("product")){
			inputDirectory = "img/product";
		}



		try {
			HttpHeaders headers = new HttpHeaders();
			URL url;
			try {
				url = new URL(s3.getFileURL(bucketName, inputDirectory+fileName));
				uCon = (HttpURLConnection) url.openConnection();
				in = uCon.getInputStream(); // 이미지를 불러옴
			} catch (Exception e) {
				url = new URL(s3.getFileURL(bucketName, "default.png"));
				uCon = (HttpURLConnection) url.openConnection();
				in = uCon.getInputStream();
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	
}
