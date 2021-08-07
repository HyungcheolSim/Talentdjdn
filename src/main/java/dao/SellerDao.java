package dao;

import java.util.List;
import java.util.Map;

import vo.SellerVo;
import vo.ThumbVo;

public interface SellerDao {

	List<SellerVo> selectList(Map map);

	int selectRowTotal(Map map);

	int insert(SellerVo vo);

	SellerVo selectOne(int s_idx);

	int update(SellerVo vo);

	int delete(int s_idx);

	ThumbVo selectOne(ThumbVo vo);

	int delete_thumb(ThumbVo vo);

	int selectCount(int s_idx);

	int insert_thumb(ThumbVo vo);

	int update_tcount(int s_idx);

}
