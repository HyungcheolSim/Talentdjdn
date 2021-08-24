package service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.TalentVo;

public interface TalentService {
	
	public Map getPagingTalentList(@RequestParam(value = "page", required = false, defaultValue = "1") int nowPage,
			@RequestParam(value = "search", required = false, defaultValue = "all") String search,
			@RequestParam(value = "search_text", required = false, defaultValue = "") String search_text);
	
	public List<TalentVo> getTalentList(Map map);
	
	public int getTalentRowTotal();
	
	public int getTalentRowTotal(Map map);
	
	//상세 페이지용 하나 읽어올 때
	public TalentVo getTalentOne(int t_idx);
	
	//재능 등록 
	public int insertTalent(TalentVo vo,@RequestParam MultipartFile image) throws Exception;
	
	
	public int deleteTalent(int t_idx) throws Exception;

	
	public int updateTalent(TalentVo vo) throws Exception;
	
	public int updateTalentStar(int t_idx) throws Exception;
}
