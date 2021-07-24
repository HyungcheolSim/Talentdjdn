package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TalentDao;
import vo.TalentVo;

@Service
public class TalentService {
	@Autowired
	private TalentDao talentDao;

	public void setTalentDao(TalentDao talentDao) {
		this.talentDao = talentDao;
	}

	public List<TalentVo> selectTalentList() {
		return talentDao.getTalentList();
	}

	public TalentVo selectOneTalent(int t_id) {
		return talentDao.selectOne(t_id);
	}

	public int insertTalent(TalentVo vo) {
		int insert = talentDao.insert(vo);
		return insert;
	}
}
