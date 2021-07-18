package vo;


public class TalentVo {
	private int t_id;
	private String t_title;
	private String t_content;
	private String t_big_field;
	private String t_small_field;
	private int t_price;
	private String t_local;
	private String t_cat;
	private String t_big_image;
	private String t_small_image;
	private String s_id;
	
	//TODO 생성자 추가
	
	
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
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
	public String getT_big_image() {
		return t_big_image;
	}
	public void setT_big_image(String t_big_image) {
		this.t_big_image = t_big_image;
	}
	public String getT_small_image() {
		return t_small_image;
	}
	public void setT_small_image(String t_small_image) {
		this.t_small_image = t_small_image;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	
	
	@Override
	public String toString() {
		return "Talent [t_id=" + t_id + ", t_title=" + t_title + ", t_content=" + t_content + ", t_big_field="
				+ t_big_field + ", t_small_field=" + t_small_field + ", t_price=" + t_price + ", t_local=" + t_local
				+ ", t_cat=" + t_cat + ", t_big_image=" + t_big_image + ", t_small_image=" + t_small_image + ", s_id="
				+ s_id + "]";
	}
	
	
	
}
