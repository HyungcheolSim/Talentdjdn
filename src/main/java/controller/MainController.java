package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MainService;


@RequestMapping("/main/")
@Controller
public class MainController {
	
	MainService mainService;
	
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	@RequestMapping("index.do")
	public String index(Model model) {
		//service에서 보내준 세 가지 list를 받아와 model에 map으로 전달하고 index로 다시 이동
		Map map=mainService.getAllLists();
		model.addAttribute("map",map);
		
		return "_jsp/index";
	}
	

}
