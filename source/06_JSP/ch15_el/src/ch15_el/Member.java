package ch15_el;

public class Member {
	private String name;
	private String id;
	private String pw;
	//el표기법도 getter setter 알아서 찾아감 필드이름 같아야함
	public Member() {
	}

	public Member(String name, String id, String pw) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
