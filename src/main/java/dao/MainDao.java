package dao;

import java.util.List;

import vo.SellerVo;
import vo.TalentVo;

public interface MainDao {

	List<TalentVo> selectTList();

	List<TalentVo> selectPList();

	List<SellerVo> selectSList();



}
