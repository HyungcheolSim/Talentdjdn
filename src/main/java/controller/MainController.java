package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MainDao;
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
		
		List<TalentVo> list = mainDao.selectList();
		
		model.addAttribute("list", list);
		
		return "_jsp/index";
	}
	

}
