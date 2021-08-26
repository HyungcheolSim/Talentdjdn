package controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import service.PurchaseService;
import vo.MemberVo;
import vo.PurchaseVo;

@Controller
@RequestMapping("/purchase/")
public class PurchaseController {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ServletContext application;

	@Autowired
	PurchaseService purchaseService;

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@RequestMapping("list.do")
	public String list(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,@RequestParam(value = "month", required = false) String month,Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");
		//구매목록 로그인 여부 확인 후 map model로 전달하고 구매목록 페이지로 이동
		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}
		int m_idx=user.getM_idx();
		Map map =purchaseService.getPurchaseList(m_idx,nowPage, month);
		model.addAttribute("map",map);
		return "_jsp/payment/payment";
		
	}
	
	@RequestMapping("soldlist.do")
	public String soldlist(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,@RequestParam(value = "month", required = false) String month,Model model) {
		//판매목록 로그인 여부 확인 후 m_idx에 해당하는 판매목록 map model로 전달하고 판매목록 페이지로 이동
		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {

			model.addAttribute("reason", "end_session");

			return "redirect:../member/login_form.do";
		}
		int m_idx=user.getM_idx();
		Map map =purchaseService.getSoldList(m_idx,nowPage, month);
		model.addAttribute("map",map);
		return "_jsp/sold/sold";
		
	}
	
	@RequestMapping("purchaselist.do")
	public String purchaselist(int t_idx,Model model) {
		//결제화면 로그인 여부 확인 후 해당하는 결제 정보 띄워서 map model로 전달하고 결제화면 페이지 이동
		MemberVo user = (MemberVo) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("reason", "end_session");
			return "redirect:../member/login_form.do";
		}
		int m_idx=user.getM_idx();
		Map map=purchaseService.getPaymentList(m_idx, t_idx);
		model.addAttribute("map",map);
		
		return "_jsp/purchase/purchase";
	}
	@RequestMapping("insert.do")
	public String insert(PurchaseVo vo,Model model) throws Exception {
		//구매(판매)목록에 추가!
		purchaseService.insertPurchase(vo);
		return "redirect:list.do";
	}
	
	@ResponseBody
	@RequestMapping("deletelist.do")
	public int delete(@RequestParam(value="chbox[]")List<String> chArr) {
		//구매(판매)목록 삭제
		int result=0;
		int pNum=0;
		for(String i:chArr) {
			pNum=Integer.parseInt(i);			
			purchaseService.deletePurchase(pNum);
			result=1;
		}
		return result;
	}
}
