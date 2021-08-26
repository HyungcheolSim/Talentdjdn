package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dao.PurchaseDao;
import dao.TalentDao;
import mycommon.MyConstant;
import util.Paging;
import vo.MemberVo;
import vo.PurchaseVo;
import vo.TalentVo;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDao purchaseDao;

	@Autowired
	TalentDao talentDao;

	@Autowired
	MemberDao memberDao;

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	public void setTalentDao(TalentDao talentDao) {
		this.talentDao = talentDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public int insertPurchase(PurchaseVo vo) throws Exception {
		//purchaseVo insert
		return purchaseDao.insert(vo);
	}

	@Override
	public Map getPurchaseList(int m_idx, int nowPage, String month) {
		// TODO 연-월검색,페이징된 m_idx에 해당하는 purchaselist 조회
		int start = (nowPage - 1) * MyConstant.Seller.BLOCK_LIST + 1;
		int end = start + MyConstant.Seller.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("m_idx", m_idx);

		if (month != null)
			map.put("month", month);

		List<PurchaseVo> list = purchaseDao.selectMonthlyList(map);
		Map resultMap = new HashMap();
		resultMap.put("list", list);
		int rowTotal = purchaseDao.selectRowTotal(m_idx);

		String pageMenu = Paging.getPaging("list.do", nowPage, rowTotal, MyConstant.Seller.BLOCK_LIST,
				MyConstant.Seller.BLOCK_PAGE);
		if (rowTotal > 0) {
			resultMap.put("pageMenu", pageMenu);
			resultMap.put("s_count", rowTotal);

			//현재 페이징된 화면에 보이는 purchaselist의 가격의 합
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i).getTalent().getT_price();
			}
			resultMap.put("totalPrice", sum);
		}
		return resultMap;
	}

	public Map getSoldList(int m_idx, int nowPage, String month) {
		// m_idx에 해당하는 페이징된 판매목록
		int start = (nowPage - 1) * MyConstant.Seller.BLOCK_LIST + 1;
		int end = start + MyConstant.Seller.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("m_idx", m_idx);

		if (month != null)
			map.put("month", month);

		List<PurchaseVo> list = purchaseDao.selectMonthlySoldList(map);
		Map resultMap = new HashMap();
		resultMap.put("list", list);
		int rowTotal = purchaseDao.selectRowTotal(m_idx);

		String pageMenu = Paging.getPaging("soldlist.do", nowPage, rowTotal, MyConstant.Seller.BLOCK_LIST,
				MyConstant.Seller.BLOCK_PAGE);
		if (rowTotal > 0) {
			resultMap.put("pageMenu", pageMenu);
			resultMap.put("s_count", rowTotal);
			
			//현재 페이징된 화면에 보이는 soldlist의 가격의 합
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i).getTalent().getT_price();
			}
			resultMap.put("totalPrice", sum);
		}
		return resultMap;
	}

	public Map getPaymentList(int m_idx, int t_idx) {
		//맴버객체하나 talent 객체 하나씩 map에 넣어 호출
		MemberVo mv = memberDao.selectOne(m_idx);
		TalentVo tv = talentDao.selectOne(t_idx);
		Map map = new HashMap();
		map.put("mv", mv);
		map.put("tv", tv);
		return map;
	}

	@Override
	public int deletePurchase(int p_idx) {
		// purchase 삭제
		return purchaseDao.delete(p_idx);
	}

}
