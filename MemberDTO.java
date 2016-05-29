package dsada;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String addr;
	private String birth;
	private String job ;
	private String gender;
	private String email;

	//��Ŭ������ : Getter/Setter �����
	//             ��Ŭ�� -> source->Generate Getters And Setters-> [Select AlL] -> [OK]
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//DTO ��ü Ȯ��
	//��Ŭ������ : toString() �ڵ�����: ��Ŭ�� -> source -> Generate toString->[OK]
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", tel=" + tel + ", addr=" + addr + ", birth=" + birth
				+ ", job=" + job + ", gender=" + gender + ", email=" + email +
				"]";
	}
}


