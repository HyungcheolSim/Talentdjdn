package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.PurchaseVo;



public class PurchaseDaoImpl implements PurchaseDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<PurchaseVo> selectMonthlyList(Map map) {
		return sqlSession.selectList("purchase.purchase_monthly_select",map);
	}

	@Override
	public int insert(PurchaseVo vo) throws Exception {
		return sqlSession.insert("purchase.purchase_insert",vo);
	}
	@Override
	public int selectRowTotal(int m_idx) {
		return sqlSession.selectOne("purchase.purchase_row_total",m_idx);
	}
	@Override
	public int delete(int p_idx) {
		return sqlSession.delete("purchase.purchase_delete",p_idx);
	}
	@Override
	public List<PurchaseVo> selectMonthlySoldList(Map map) {
		return sqlSession.selectList("purchase.sold_monthly_select",map);
	}

	

}
