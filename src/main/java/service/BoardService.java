package service;

import java.util.List;
import java.util.Map;

import vo.BoardVo;



public interface BoardService {

	int getBoardRowTotal(Map map);

	List<BoardVo> getBoardList(Map map);

	int insertBoard(BoardVo vo) throws Exception;

	BoardVo getOneBoard(int b_idx);

	int updateBoardReadHit(int b_idx) throws Exception;

	int deleteBoard(int b_idx)  throws Exception;

	int updateBoard(BoardVo vo) throws Exception;
	BoardVo getOneBoardAndUpdateReadHit(int b_idx);

	Map getPagingBoardList(int nowPage, String search, String search_text);

}
