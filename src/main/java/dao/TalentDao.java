package dao;

import java.util.List;

import vo.TalentVo;

public interface TalentDao {

	
	public List<TalentVo> selectList();
	
	
	public TalentVo selectOne(int s_id);
	
	
	public int insert(TalentVo vo);
	
	
	public int delete(int s_id);

	
	public int update(TalentVo vo);
}
