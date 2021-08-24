package dao;
import java.util.List;
import java.util.Map;

import vo.PurchaseVo;

public interface PurchaseDao {
	public List<PurchaseVo> selectMonthlyList(Map map);
	public List<PurchaseVo> selectMonthlySoldList(Map map);
	public int insert(PurchaseVo vo) throws Exception;
	public int selectRowTotal(int m_idx);
	public int delete(int p_idx); 

}
