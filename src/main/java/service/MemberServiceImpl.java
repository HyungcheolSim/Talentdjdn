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
		// member 목록 조회
		return memberDao.selectList();
	}

	public Map checkMemberId(String m_id) {
		//memberId 확인한 결과 result로 map에 넣어 리턴
		Map map = new HashMap();

		boolean bResult;
		MemberVo vo = memberDao.selectOne(m_id);

		if (vo == null) {
			bResult = true;
		} else {
			
			bResult = false;
		}

		map.put("result", bResult);

		return map;
	}

	@Override
	public int insertMember(MemberVo vo) {
		// member 등록
		return memberDao.insert(vo);
	}

	@Override
	public int deleteMember(int m_idx) {
		// member 삭제
		return memberDao.delete(m_idx);
	}

	@Override
	public int updateMember(MemberVo vo) {
		// member update
		return memberDao.update(vo);
	}

	@Override
	public MemberVo getMemberOne(int m_idx) {
		// m_idx로 멤버 하나 조회
		return memberDao.selectOne(m_idx);
	}

	@Override
	public MemberVo getMemberOne(String m_id) {
		// m_id로 멤버 하나 조회
		return memberDao.selectOne(m_id);
	}

	@Override
	public int delete(int m_idx) {
		// 멤버 삭제
		return memberDao.delete(m_idx);
	}

	@Override
	public Map getPagingMemberList(int nowPage) {
		//페이징된 member목록 조회
		int start = (nowPage - 1) * MyConstant.Member.BLOCK_LIST + 1;
		int end = start + MyConstant.Member.BLOCK_LIST - 1;
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<ReviewVo> list = memberDao.selectList(map);

        int row_total = memberDao.selectRowTatal();
      
        String pageMenu = Paging.getPaging("list.do",nowPage, row_total, 
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
		// m_idx에 해당하는 seller목록 조회
		return memberDao.selectSellerList(m_idx);
	}

}
