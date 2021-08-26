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
		// m_idx에 해당하는 관심목록 조회		
		return interestDao.selectList(m_idx);
	}

	@Override
	public Map delete(int t_idx) {
		// 삭제 후 성공여부 map에 result로 넣어 반환
		int res = 0;
		
		try {
			res = interestDao.delete(t_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		Map map = new HashMap();
		map.put("result", (res==1) ? "success" : "fail"); // { "result" : "success" }
		return map;
	}

	@Override
	public Map insert(InterestVo vo) {
		// interest 등록 결과 result로 map에 넣어 return
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
			e.printStackTrace();
		}
		map.put("result", (res==1) ? "success":"fail");											
		return map;
	}

	@Override
	public int deleteInterest(int pNum) {
		// interest delete
		return interestDao.delete(pNum);
	}
	
	
}
