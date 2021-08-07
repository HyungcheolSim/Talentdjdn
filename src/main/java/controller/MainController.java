package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MainDao;
import vo.SellerVo;
import vo.TalentVo;

@RequestMapping("/main/")
@Controller
public class MainController {
	
	MainDao mainDao;

	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
	@RequestMapping("index.do")
	public String index(Model model) {
		
		List<TalentVo> t_list = mainDao.selectTList();
		List<TalentVo> p_list = mainDao.selectPList();
		List<SellerVo> s_list = mainDao.selectSList();
		
		model.addAttribute("t_list", t_list);
		model.addAttribute("p_list", p_list);
		model.addAttribute("s_list", s_list);
		
		return "_jsp/index";
	}
	

}
