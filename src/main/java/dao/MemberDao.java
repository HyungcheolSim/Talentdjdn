package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {

	
	public List<MemberVo> selectList();
	
	
	public int insert(MemberVo vo);
	
	
	public int delete(String m_id);

	
	public int update(MemberVo vo);


	public MemberVo selectOne(int m_id);


	public MemberVo selectOne(String m_id);
}
