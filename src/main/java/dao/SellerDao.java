package dao;

import java.util.List;
import java.util.Map;

import vo.SellerVo;

public interface SellerDao {

	List<SellerVo> selectList(Map map);

	int selectRowTotal(Map map);

	int insert(SellerVo vo);

	SellerVo selectOne(int s_idx);

	int update(SellerVo vo);

	int delete(int s_idx);

}
