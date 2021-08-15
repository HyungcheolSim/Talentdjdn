package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.BoardVo;
import vo.PurchaseVo;
import vo.TalentVo;


public class PurchaseDaoImpl implements PurchaseDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<PurchaseVo> selectMonthlyList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("purchase.purchase_monthly_select",map);
	}

	@Override
	public int insert(PurchaseVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("purchase.purchase_insert",vo);
	}

	

}
