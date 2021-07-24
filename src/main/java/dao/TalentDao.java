package dao;

import java.util.List;

import vo.TalentVo;

public interface TalentDao {

	//재능 목록 (모든 talent 출력)
	public List<TalentVo> getTalentList();
	
	//상세 페이지용 하나 읽어올 때
	public TalentVo selectOne(int t_id);
	
	//재능 등록 
	public int insert(TalentVo vo);
	
	
	public int delete(int t_id);

	
	public int update(TalentVo vo);
}
