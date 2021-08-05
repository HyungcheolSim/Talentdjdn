package vo;

import java.sql.Date;

public class TalentVo {

	int    t_idx;
	String    t_title;
	String t_content;
	String t_big_field;
	String t_small_field;
	int    t_price;
	String t_local;
	String t_cat;
	double t_starscore;
	String t_image;
	Date t_regdate;
	int s_idx;
	
	SellerVo seller;
	
	
	public SellerVo getSeller() {
		return seller;
	}
	public void setSeller(SellerVo seller) {
		this.seller = seller;
	}
	public Date getT_regdate() {
		return t_regdate;
	}
	public void setT_regdate(Date t_regdate) {
		this.t_regdate = t_regdate;
	}
	public int getT_idx() {
		return t_idx;
	}
	public void setT_idx(int t_idx) {
		this.t_idx = t_idx;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	public String getT_big_field() {
		return t_big_field;
	}
	public void setT_big_field(String t_big_field) {
		this.t_big_field = t_big_field;
	}
	public String getT_small_field() {
		return t_small_field;
	}
	public void setT_small_field(String t_small_field) {
		this.t_small_field = t_small_field;
	}
	public int getT_price() {
		return t_price;
	}
	public void setT_price(int t_price) {
		this.t_price = t_price;
	}
	public String getT_local() {
		return t_local;
	}
	public void setT_local(String t_local) {
		this.t_local = t_local;
	}
	public String getT_cat() {
		return t_cat;
	}
	public void setT_cat(String t_cat) {
		this.t_cat = t_cat;
	}
	public double getT_starscore() {
		return t_starscore;
	}
	public void setT_starscore(double t_starscore) {
		this.t_starscore = t_starscore;
	}
	public String getT_image() {
		return t_image;
	}
	public void setT_image(String t_image) {
		this.t_image = t_image;
	}
	public int getS_idx() {
		return s_idx;
	}
	public void setS_idx(int s_idx) {
		this.s_idx = s_idx;
	}
	

	
}
