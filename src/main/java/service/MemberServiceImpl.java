package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import mycommon.MyConstant;
import util.Paging;
import vo.MemberVo;
import vo.ReviewVo;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	@Autowired
	HttpSession session;
	
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

	@Override
	public Map getPagingMemberList(int nowPage) {
		// TODO Auto-generated method stub
		int start = (nowPage - 1) * MyConstant.Member.BLOCK_LIST + 1;
		int end = start + MyConstant.Member.BLOCK_LIST - 1;
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<ReviewVo> list = memberDao.selectList(map);

        int row_total = memberDao.selectRowTatal();
      
        String pageMenu = Paging.getMemberPaging(nowPage, row_total, 
                                        MyConstant.Member.BLOCK_LIST, 
                                        MyConstant.Member.BLOCK_PAGE);
       
	    Map resultMap = new HashMap();
	    resultMap.put("list", list);
	    if(row_total>0){
		    resultMap.put("pageMenu", pageMenu);
		    }
	    return resultMap;
}

	@Override
	public List getSellerList(int m_idx) {
		// TODO Auto-generated method stub
		return memberDao.selectSellerList(m_idx);
	}

}
