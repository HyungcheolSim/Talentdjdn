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

import dao.TalentDao;
import mycommon.MyConstant;
import util.Paging;
import util.UploadFileUtils;
import vo.TalentVo;

@Service
public class TalentServiceImpl implements TalentService {

	@Autowired
	TalentDao talentDao;

	public void setTalentDao(TalentDao talentDao) {
		this.talentDao = talentDao;
	}
	
	@Override
	public Map getPagingTalentList(int nowPage, String search, String search_text) {
		int start = (nowPage - 1) * MyConstant.Talent.BLOCK_LIST + 1;
		int end = start + MyConstant.Talent.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start); //한 페이지에 들어갈 인덱스 시작, 끝을 Map에 넣어 전달
		map.put("end", end);

		//Search의 내용에 따라 어떤 컬럼에서 search text를 검색할지 구분
		if (search.equals("name")) {	
			map.put("name", search_text);
		} else if (search.equals("subject")) {
			map.put("subject", search_text);
		} else if (search.equals("content")) {
			map.put("content", search_text);
		} else if (search.equals("bfield")) {
			map.put("bfield", search_text);
		} else if (search.equals("subject_content")) {
			map.put("subject", search_text);
			map.put("content", search_text);
		}
		
		//map을 전달하고 talentVo로 이루어진 list를 받아온다
		List<TalentVo> list=talentDao.selectList(map);
		//list의 행 수 가져오기
		int rowTotal = talentDao.selectRowTotal(map);

		String search_filter = String.format("&search=%s&search_text=%s", search, search_text);

		String pageMenu = Paging.getPaging("talentlist.do", nowPage, rowTotal, search_filter,
				MyConstant.Talent.BLOCK_LIST, MyConstant.Talent.BLOCK_PAGE);
		//리턴해줄 맵 객체 생성해 가져온 list와 pagemenu를 넣는다.
		Map resultMap = new HashMap();
		resultMap.put("list", list);
		if(rowTotal>0) {
			resultMap.put("pageMenu", pageMenu);
		}
		return resultMap;
	}
	
	@Override
	public List<TalentVo> getTalentList(Map map) {
		return talentDao.selectList(map);
	}

	@Override
	public int getTalentRowTotal() {
		// 전체 talent의 개수를 리턴
		return talentDao.selectRowTotal();
	}

	@Override
	public int getTalentRowTotal(Map map) {
		// map으로 넘겨준 정보에 해당하는 talent의 개수를 리턴
		return talentDao.selectRowTotal(map);
	}

	@Override
	public TalentVo getTalentOne(int t_idx) {
		// 하나의 talent를 t_idx로 조회
		return talentDao.selectOne(t_idx);
	}

	@Override
	public int insertTalent(TalentVo vo,@RequestParam MultipartFile image) throws Exception {
		// talent 등록 중 이미지 업로드 시 upload path, image path 설정하는 코드
		String uploadpath = "img/talent";

		ResponseEntity<String> img_path = new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadpath, image.getOriginalFilename(), image.getBytes()),
				HttpStatus.CREATED);
		String imagePath = (String) img_path.getBody();
		
		vo.setT_image(imagePath);
		//앤터키를 <br>로 대체시켜 보일 때 줄바꿈이 되도록 설정
		String s_msg = vo.getT_content().replaceAll("\r\n", "<br>");
		vo.setT_content(s_msg);
		
		return talentDao.insert(vo);
	}

	@Override
	public int deleteTalent(int t_idx) throws Exception {
		// t_idx에 해당하는 talent 삭제
		return talentDao.delete(t_idx);
	}

	@Override
	public int updateTalent(TalentVo vo) throws Exception {
		// 파라미터로 받은 vo를 업데이트		
		String s_msg = vo.getT_content().replaceAll("<br>", "\r\n");
		vo.setT_content(s_msg);
		return talentDao.update(vo);
	}

	@Override
	public int updateTalentStar(int t_idx) throws Exception {
		// t_idx에 해당하는 starscore를 업데이트
		return talentDao.updateStar(t_idx);
	}

}
