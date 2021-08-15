package vo;

import java.util.Date;

public class PurchaseVo {
	int p_idx;
	String p_address;
	String p_email;
	Date p_regdate;

	int m_idx;
	int t_idx;
	
	MemberVo member;
	TalentVo talent;
	
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public Date getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public int getT_idx() {
		return t_idx;
	}
	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}
	public MemberVo getMember() {
		return member;
	}
	public void setMember(MemberVo member) {
		this.member = member;
	}
	public TalentVo getTalent() {
		return talent;
	}
	public void setTalent(TalentVo talent) {
		this.talent = talent;
	}
}
