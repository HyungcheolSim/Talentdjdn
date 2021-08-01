package dao;

import java.util.List;
import java.util.Map;

import vo.TalentVo;

public interface TalentDao {

	//재능 목록 (모든 talent 출력)
	public List<TalentVo> getTalentList();
	
	public List<TalentVo> selectList(Map map);
	
	public int selectRowTotal();
	
	public int selectRowTotal(Map map);
	
	//상세 페이지용 하나 읽어올 때
	public TalentVo selectOne(int t_idx);
	
	//재능 등록 
	public int insert(TalentVo vo) throws Exception;
	
	
	public int delete(int t_idx) throws Exception;

	
	public int update(TalentVo vo) throws Exception;
	
	public int updateStar(int t_idx) throws Exception;
}
