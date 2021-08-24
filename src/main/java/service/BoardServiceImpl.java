package service;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import dao.BoardDao;
import mycommon.MyConstant;
import util.Paging;
import vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Autowired
	HttpSession session;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map getPagingBoardList(int nowPage, String search, String search_text) {
		int start = (nowPage - 1) * MyConstant.Board.BLOCK_LIST + 1;
		int end = start + MyConstant.Board.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		if (search.equals("name")) {
			map.put("name", search_text);
		} else if (search.equals("subject")) {
			map.put("subject", search_text);
		} else if (search.equals("content")) {
			map.put("content", search_text);
		} else if (search.equals("subject_content")) {
			map.put("subject", search_text);
			map.put("content", search_text);
		}

		List<BoardVo> list = boardDao.selectList(map);

		int rowTotal = boardDao.selectRowTotal(map);

		String search_filter = String.format("&search=%s&search_text=%s", search, search_text);

		String pageMenu = Paging.getPaging("list.do", nowPage, rowTotal, search_filter, MyConstant.Board.BLOCK_LIST,
				MyConstant.Board.BLOCK_PAGE);

		Map resultMap = new HashMap();
		resultMap.put("list", list);
		if (rowTotal > 0) {
			resultMap.put("pageMenu", pageMenu);
		}


		
		return resultMap;
	}

	@Override
	public int getBoardRowTotal(Map map) {
		int row = boardDao.selectRowTotal(map);
		return row;
	}

	@Override
	public List<BoardVo> getBoardList(Map map) {
		List<BoardVo> list = boardDao.selectList();
		return list;
	}

	@Override
	public int insertBoard(BoardVo vo) {

		String b_content = vo.getB_content().replaceAll("\r\n", "<br>");
		vo.setB_content(b_content);
		int insert = 0;
		try {
			insert = boardDao.insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;
	}

	@Override
	public BoardVo getOneBoard(int b_idx) {
		BoardVo bv = boardDao.selectOne(b_idx);
		/*
		 * String content = bv.getB_content().replaceAll("<br>", "\r\n");
		 * bv.setB_content(content);
		 */

		return bv;
	}

	@Override
	public int updateBoardReadHit(int b_idx) throws Exception {

	      int res = boardDao.update_readhit(b_idx);//조회수증가
	      return res;
	}

	@Override
	public int deleteBoard(int b_idx) throws Exception {
		// TODO Auto-generated method stub
		int delete = boardDao.delete(b_idx);
		return delete;
	}

	@Override
	public int updateBoard(BoardVo vo) throws Exception {
		String b_content = vo.getB_content().replaceAll("\r\n","<br>");
		vo.setB_content(b_content);
		int update = boardDao.update(vo);
		return update;
	}

	@Override
	public BoardVo getOneBoardAndUpdateReadHit(int b_idx) {
		BoardVo vo = boardDao.selectOne(b_idx);

		try {

			int res = boardDao.update_readhit(b_idx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo;
	}

}
