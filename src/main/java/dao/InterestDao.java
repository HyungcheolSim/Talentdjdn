package dao;

import java.util.List;

import vo.InterestVo;

public interface InterestDao {

	List<InterestVo> selectList(int m_idx);

	int delete(int t_idx);

	int insert(InterestVo vo);

	InterestVo selectOne(InterestVo vo);

}
