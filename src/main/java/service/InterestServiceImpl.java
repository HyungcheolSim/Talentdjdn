package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import dao.InterestDao;
import vo.InterestVo;

public class InterestServiceImpl implements InterestService {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	InterestDao interestDao;

	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}

	@Override
	public List<InterestVo> selectList(int m_idx) {
		// TODO Auto-generated method stub
		
		return interestDao.selectList(m_idx);
	}

	@Override
	public Map delete(int t_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = interestDao.delete(t_idx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		Map map = new HashMap();
			
		map.put("result", (res==1) ? "success" : "fail"); // { "result" : "success" }
			
		return map;
	}

	@Override
	public Map insert(InterestVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Map map = new HashMap();
				
		try {
			
			InterestVo vo1 = interestDao.selectOne(vo);
		    if(vo1!=null) {
		    	
		    	map.put("result", "exists");
		    	return map;
		    }
		    
			
			res = interestDao.insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("result", (res==1) ? "success":"fail");	
														
		return map;
	}
	
	
}
