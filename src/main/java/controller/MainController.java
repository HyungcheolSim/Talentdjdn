package controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MainDao;
import service.MainService;
import vo.SellerVo;
import vo.TalentVo;

@RequestMapping("/main/")
@Controller
public class MainController {
	
	MainService mainService;
	
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	@RequestMapping("index.do")
	public String index(Model model) {
		
		Map map=mainService.getAllLists();
		model.addAttribute("map",map);
		
		return "_jsp/index";
	}
	

}
