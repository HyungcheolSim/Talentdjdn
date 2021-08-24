package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
		int start = (nowPage - 1) * MyConstant.Board.BLOCK_LIST + 1;
		int end = start + MyConstant.Board.BLOCK_LIST - 1;

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);

		// �˻������� Map�� �߰�

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
		List<TalentVo> list=talentDao.selectList(map);

		int rowTotal = talentDao.selectRowTotal(map);

		String search_filter = String.format("&search=%s&search_text=%s", search, search_text);

		String pageMenu = Paging.getPaging("talentlist.do", nowPage, rowTotal, search_filter,
				MyConstant.Board.BLOCK_LIST, MyConstant.Board.BLOCK_PAGE);

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
		// TODO Auto-generated method stub

		return talentDao.selectRowTotal();
	}

	@Override
	public int getTalentRowTotal(Map map) {
		// TODO Auto-generated method stub
		return talentDao.selectRowTotal(map);
	}

	@Override
	public TalentVo getTalentOne(int t_idx) {
		// TODO Auto-generated method stub
		return talentDao.selectOne(t_idx);
	}

	@Override
	public int insertTalent(TalentVo vo,@RequestParam MultipartFile image) throws Exception {
		// TODO Auto-generated method stub
		String uploadpath = "img/talent";

		ResponseEntity<String> img_path = new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadpath, image.getOriginalFilename(), image.getBytes()),
				HttpStatus.CREATED);
		String imagePath = (String) img_path.getBody();
		
		vo.setT_image(imagePath);
		String s_msg = vo.getT_content().replaceAll("\r\n", "<br>");
		vo.setT_content(s_msg);
		
		return talentDao.insert(vo);
	}

	@Override
	public int deleteTalent(int t_idx) throws Exception {
		// TODO Auto-generated method stub
		return talentDao.delete(t_idx);
	}

	@Override
	public int updateTalent(TalentVo vo) throws Exception {
		// TODO Auto-generated method stub
		
		String s_msg = vo.getT_content().replaceAll("<br>", "\r\n");
		vo.setT_content(s_msg);
		return talentDao.update(vo);
	}

	@Override
	public int updateTalentStar(int t_idx) throws Exception {
		// TODO Auto-generated method stub
		return talentDao.updateStar(t_idx);
	}




}
