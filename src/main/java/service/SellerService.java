package service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.SellerVo;
import vo.ThumbVo;

public interface SellerService {
	
	Map getPagingSellerList(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search_text1", required = false, defaultValue = "") String search_text1,
			@RequestParam(value = "search_text2", required = false, defaultValue = "") String search_text2);
	

	int getSellerRowTotal(Map map);

	int insertSeller(SellerVo vo,@RequestParam MultipartFile potfolio);

	SellerVo getSellerOne(int s_idx);
	//TODO 짚고 넘어가야함 sellervo 받는데 thumbvo 받고있음
	SellerVo getSellerOne(SellerVo vo);

	int updateSeller(SellerVo vo);

	int deleteSeller(int s_idx);

	ThumbVo getSellerOne(ThumbVo vo);

	int deleteThumb(ThumbVo vo);

	int getSellerCount(int s_idx);

	Map insertThumb(ThumbVo vo);

	int update_Sellertcount(int s_idx);
	
	
}
