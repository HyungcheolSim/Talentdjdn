package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MainDao;
import vo.SellerVo;
import vo.TalentVo;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	MainDao mainDao;

	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	@Override
	public Map getAllLists() {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		
		List<TalentVo> t_list=mainDao.selectTList();
		List<TalentVo> p_list=mainDao.selectPList();
		List<SellerVo> s_list=mainDao.selectSList();
		map.put("t_list", t_list);
		map.put("p_list", p_list);
		map.put("s_list", s_list);
		return map;
	}



	
	
}
