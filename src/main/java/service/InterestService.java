package service;

import java.util.List;
import java.util.Map;

import vo.InterestVo;

public interface InterestService {

	List<InterestVo> selectList(int m_idx);

	Map delete(int t_idx);

	Map insert(InterestVo vo);

	int deleteInterest(int pNum);

}
