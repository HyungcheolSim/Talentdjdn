package vo;

public class SellerVo {
	private String s_id;
	private String s_account;
	private String s_field;
	private int s_rank;
	private String s_career;
	private String s_education;
	private String s_license;
	private String s_potfolio;
	private String s_skill;
	private String s_local;
	
	//TODO 생성자 추가
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_account() {
		return s_account;
	}
	public void setS_account(String s_account) {
		this.s_account = s_account;
	}
	public String getS_field() {
		return s_field;
	}
	public void setS_field(String s_field) {
		this.s_field = s_field;
	}
	public int getS_rank() {
		return s_rank;
	}
	public void setS_rank(int s_rank) {
		this.s_rank = s_rank;
	}
	public String getS_career() {
		return s_career;
	}
	public void setS_career(String s_career) {
		this.s_career = s_career;
	}
	public String getS_education() {
		return s_education;
	}
	public void setS_education(String s_education) {
		this.s_education = s_education;
	}
	public String getS_license() {
		return s_license;
	}
	public void setS_license(String s_license) {
		this.s_license = s_license;
	}
	public String getS_potfolio() {
		return s_potfolio;
	}
	public void setS_potfolio(String s_potfolio) {
		this.s_potfolio = s_potfolio;
	}
	public String getS_skill() {
		return s_skill;
	}
	public void setS_skill(String s_skill) {
		this.s_skill = s_skill;
	}
	public String getS_local() {
		return s_local;
	}
	public void setS_local(String s_local) {
		this.s_local = s_local;
	}
	
	
	@Override
	public String toString() {
		return "Seller [s_id=" + s_id + ", s_account=" + s_account + ", s_field=" + s_field + ", s_rank=" + s_rank
				+ ", s_career=" + s_career + ", s_education=" + s_education + ", s_license=" + s_license
				+ ", s_potfolio=" + s_potfolio + ", s_skill=" + s_skill + ", s_local=" + s_local + "]";
	}

	
}
