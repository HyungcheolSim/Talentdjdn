package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<MemberVo> getMemberList() {
		// TODO Auto-generated method stub
		return memberDao.selectList();
	}

	public Map checkMemberId(String m_id) {
		Map map = new HashMap();

		// DB���� m_id���翩�� �˻�
		boolean bResult;
		MemberVo vo = memberDao.selectOne(m_id);

		if (vo == null) {// ��밡���� ID
			bResult = true;
		} else {
			// ������� ID
			bResult = false;
		}

		map.put("result", bResult);

		return map;
	}

	@Override
	public int insertMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.insert(vo);
	}

	@Override
	public int deleteMember(int m_idx) {
		// TODO Auto-generated method stub
		return memberDao.delete(m_idx);
	}

	@Override
	public int updateMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.update(vo);
	}

	@Override
	public MemberVo getMemberOne(int m_id) {
		// TODO Auto-generated method stub
		return memberDao.selectOne(m_id);
	}

	@Override
	public MemberVo getMemberOne(String m_id) {
		// TODO Auto-generated method stub
		return memberDao.selectOne(m_id);
	}

	@Override
	public int delete(int m_idx) {
		// TODO Auto-generated method stub
		return memberDao.delete(m_idx);
	}

}
