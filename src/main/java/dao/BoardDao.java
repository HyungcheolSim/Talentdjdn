package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVo;

public interface BoardDao {

	List<BoardVo> selectList();
	List<BoardVo> selectList(Map map);
	BoardVo       selectOne(int b_idx);
	int           selectRowTotal();
	int           selectRowTotal(Map map);
	
	
	int           insert(BoardVo vo)  throws Exception;
	int           update(BoardVo vo)  throws Exception;
	int           update_readhit(int b_idx) throws Exception;  
	int           delete(int b_idx)         throws Exception;
}
