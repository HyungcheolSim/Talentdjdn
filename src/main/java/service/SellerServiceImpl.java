package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.SellerDao;
import mycommon.MyConstant;
import util.Paging;
import util.UploadFileUtils;
import vo.SellerVo;
import vo.ThumbVo;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerDao sellerDao;

	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}

	//페이징한 seller list
	@Override
	public Map getPagingSellerList(int nowPage, String search_text1, String search_text2) {
		int start = (nowPage - 1) * MyConstant.Seller.BLOCK_LIST + 1;
		int end = start + MyConstant.Seller.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		//search_text1과 2가 각각 존재할 경우 해당하는 column 내에서 search_text 검색
		if (!search_text1.isEmpty()) {
			map.put("s_local", search_text1);
		}
		if (!search_text2.isEmpty()) {
			map.put("s_field", search_text2);
		}
		List<SellerVo> list = sellerDao.selectList(map);
		map.remove("start");
		map.remove("end");
		int rowTotal = sellerDao.selectRowTotal(map);

		String search_filter = String.format("&search_text1=%s&search_text2=%s", search_text1, search_text2);

		String pageMenu = Paging.getPaging("list.do", nowPage, rowTotal, search_filter, MyConstant.Seller.BLOCK_LIST,
				MyConstant.Seller.BLOCK_PAGE);
		//리턴해줄 Map 생성해 list, pagemenu s_count(조회된 seller 개수) 넣는다.
		Map resultMap = new HashMap();
		resultMap.put("list", list);
		if (rowTotal > 0) {
			resultMap.put("pageMenu", pageMenu);
			resultMap.put("s_count", rowTotal);
		}

		return resultMap;
	}

	@Override
	public int getSellerRowTotal(Map map) {
		// map에 해당하는 row 수 리턴
		return sellerDao.selectRowTotal(map);
	}

	@Override
	public int insertSeller(SellerVo vo, @RequestParam MultipartFile potfolio) {
		// seller에 image 관련 설정 upload path 설정, potfolio에 path 넣기
		String uploadpath = "img/seller";
		ResponseEntity<String> img_path = null;
		try {
			img_path = new ResponseEntity<String>(
					UploadFileUtils.uploadFile(uploadpath, potfolio.getOriginalFilename(), potfolio.getBytes()),
					HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String potfolioPath = (String) img_path.getBody();
		vo.setS_potfolio(potfolioPath);
		
		String s_msg = vo.getS_msg().replaceAll("\r\n", "<br>");
		vo.setS_msg(s_msg);

		return sellerDao.insert(vo);
	}

	@Override
	public SellerVo getSellerOne(int s_idx) {
		// Seller 객체 하나 조회
		return sellerDao.selectOne(s_idx);
	}

	@Override

	public int updateSeller(SellerVo vo) {
		// seller update
		String s_msg = vo.getS_msg().replaceAll("\r\n", "<br>");
		vo.setS_msg(s_msg);

		return sellerDao.update(vo);
	}

	@Override
	public int deleteSeller(int s_idx) {
		// seller 삭제
		return sellerDao.delete(s_idx);
	}

	@Override
	public ThumbVo getSellerOne(ThumbVo vo) {
		// TODO 확인해봐야함
		return sellerDao.selectOne(vo);
	}

	@Override
	public int deleteThumb(ThumbVo vo) {
		// thumb 삭제
		return sellerDao.delete_thumb(vo);
	}

	@Override
	public int getSellerCount(int s_idx) {
		// TODO 이것도 확인해봐야함. 이름을 한번씩 체크해야할듯
		return sellerDao.selectCount(s_idx);
	}

	@Override
	public Map insertThumb(ThumbVo vo) {
		
		Map map = new HashMap();
		// TODO 여기도 확인해봐야함
		ThumbVo thumb = sellerDao.selectOne(vo);

		if (thumb != null) {
			int res = sellerDao.delete_thumb(vo);
			int cnt = sellerDao.selectCount(vo.getS_idx());
			sellerDao.update_tcount(vo.getS_idx());

			map.put("result", "cancle_success");
			map.put("count", cnt);

		} else {
			int res = sellerDao.insert_thumb(vo);
			int cnt = sellerDao.selectCount(vo.getS_idx());
			sellerDao.update_tcount(vo.getS_idx());

			map.put("result", "success");
			map.put("count", cnt);
		}

		return map;

	}

	@Override
	public int update_Sellertcount(int s_idx) {
		// seller tcount update
		return sellerDao.update_tcount(s_idx);
	}

	@Override
	
	//TODO 이것도 이상함. vo받고 vo를 다시설정?
	public SellerVo getSellerOne(SellerVo vo) {
		vo = sellerDao.selectOne(vo.getS_idx());

		String msg = vo.getS_msg().replaceAll("<br>", "\r\n");
		vo.setS_msg(msg);

		return vo;
	}

}
