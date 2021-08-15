package service;

import java.util.List;
import java.util.Map;

import vo.MemberVo;

public interface MemberService {
	public List<MemberVo> getMemberList();

	public int insertMember(MemberVo vo);

	public int deleteMember(int m_idx);

	public int updateMember(MemberVo vo);

	public MemberVo getMemberOne(int m_id);

	public MemberVo getMemberOne(String m_id);
	
	public Map checkMemberId(String m_id);

	public int delete(int m_idx);

	Map getPagingMemberList(int nowPage);

}
