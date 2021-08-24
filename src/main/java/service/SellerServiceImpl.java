package service;

import java.io.IOException;
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

	@Override
	public Map getPagingSellerList(int nowPage, String search_text1, String search_text2) {
		int start = (nowPage - 1) * MyConstant.Seller.BLOCK_LIST + 1;
		int end = start + MyConstant.Seller.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);

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
		Map resultMap = new HashMap();
		resultMap.put("list", list);
		if (rowTotal > 0) {
			resultMap.put("pageMenu", pageMenu);
			resultMap.put("s_count", rowTotal);
		}

		return resultMap;
	}

	@Override
	public List<SellerVo> getSellerList(Map map) {
		// TODO Auto-generated method stub
		return sellerDao.selectList(map);
	}

	@Override
	public int getSellerRowTotal(Map map) {
		// TODO Auto-generated method stub
		return sellerDao.selectRowTotal(map);
	}

	@Override
	public int insertSeller(SellerVo vo, @RequestParam MultipartFile potfolio) {
		// TODO Auto-generated method stub
	
		String uploadpath = "img/seller";

		ResponseEntity<String> img_path = null;
		try {
			img_path = new ResponseEntity<String>(
					UploadFileUtils.uploadFile(uploadpath, potfolio.getOriginalFilename(), potfolio.getBytes()),
					HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		return sellerDao.selectOne(s_idx);
	}

	@Override

	public int updateSeller(SellerVo vo) {
		// TODO Auto-generated method stub
	
		String s_msg = vo.getS_msg().replaceAll("\r\n", "<br>");

		vo.setS_msg(s_msg);

		return sellerDao.update(vo);
	}

	@Override
	public int deleteSeller(int s_idx) {
		// TODO Auto-generated method stub
		return sellerDao.delete(s_idx);
	}

	@Override
	public ThumbVo getSellerOne(ThumbVo vo) {
		// TODO Auto-generated method stub
		return sellerDao.selectOne(vo);
	}

	@Override
	public int deleteThumb(ThumbVo vo) {
		// TODO Auto-generated method stub
		return sellerDao.delete_thumb(vo);
	}

	@Override
	public int getSellerCount(int s_idx) {
		// TODO Auto-generated method stub
		return sellerDao.selectCount(s_idx);
	}

	@Override
	public Map insertThumb(ThumbVo vo) {
		// TODO Auto-generated method stub
		Map map = new HashMap();

		ThumbVo thumb = sellerDao.selectOne(vo);

		if (thumb != null) {
			int res = sellerDao.delete_thumb(vo);
			int cnt = sellerDao.selectCount(vo.getS_idx());

			map.put("result", "cancle_success");
			map.put("count", cnt);

		} else {
			int res = sellerDao.insert_thumb(vo);
			int cnt = sellerDao.selectCount(vo.getS_idx());

			map.put("result", "success");
			map.put("count", cnt);
		}

		return map;

	}

	@Override
	public int update_Sellertcount(int s_idx) {
		// TODO Auto-generated method stub

		return sellerDao.update_tcount(s_idx);
	}

	@Override
	public SellerVo getSellerOne(SellerVo vo) {
		vo = sellerDao.selectOne(vo.getS_idx());

		String msg = vo.getS_msg().replaceAll("<br>", "\r\n");
		vo.setS_msg(msg);

		return vo;
	}

}
