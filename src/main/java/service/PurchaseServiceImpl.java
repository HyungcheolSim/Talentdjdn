package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dao.PurchaseDao;
import dao.TalentDao;
import mycommon.MyConstant;
import util.Paging;
import vo.MemberVo;
import vo.PurchaseVo;
import vo.SellerVo;
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
		// TODO Auto-generated method stub

		// 구매목록 추가시 상품일 경우 상품 삭제
		int t_idx = vo.getT_idx();
		TalentVo tv = talentDao.selectOne(t_idx);
		if (tv.getT_cat().equals("상품")) {
			talentDao.delete(t_idx);
		}
		return purchaseDao.insert(vo);
	}

	@Override
	public Map getPurchaseList(int m_idx, int nowPage, String month) {
		// TODO Auto-generated method stub
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
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {

				sum += list.get(i).getTalent().getT_price();
			}
			resultMap.put("totalPrice", sum);
		}
		return resultMap;
	}

	public Map getPaymentList(int m_idx, int t_idx) {
		MemberVo mv = memberDao.selectOne(m_idx);
		TalentVo tv = talentDao.selectOne(t_idx);
		Map map = new HashMap();
		map.put("mv", mv);
		map.put("tv", tv);
		return map;
	}

}
