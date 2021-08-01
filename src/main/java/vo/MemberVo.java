package vo;

import java.sql.Date;

public class MemberVo {

	int    m_idx;
	String m_id;
	String m_pwd;
	String m_name;
	String m_addr;
	String m_detail_addr;
	int    m_zipcode;
	String m_email;
	String m_phone;
	String m_local;
	String m_grade;
	Date   m_date;
	
	
	
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_detail_addr() {
		return m_detail_addr;
	}
	public void setM_detail_addr(String m_detail_addr) {
		this.m_detail_addr = m_detail_addr;
	}
	public int getM_zipcode() {
		return m_zipcode;
	}
	public void setM_zipcode(int m_zipcode) {
		this.m_zipcode = m_zipcode;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_local() {
		return m_local;
	}
	public void setM_local(String m_local) {
		this.m_local = m_local;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	
	
	
}
