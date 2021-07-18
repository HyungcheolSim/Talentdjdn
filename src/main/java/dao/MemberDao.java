package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {

	//전체목록 보기
	public List<MemberVo> selectList();
	
	//m_id에 해당되는 회원정보 1건 얻어오기
	public MemberVo selectOne(String m_id);
	
	//추가
	public int insert(MemberVo vo);
	
	//삭제
	public int delete(String m_id);

	//수정
	public int update(MemberVo vo);
}
