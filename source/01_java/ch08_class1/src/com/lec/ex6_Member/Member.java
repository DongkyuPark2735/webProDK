package com.lec.ex6_Member;

public class Member {//데이터 형식
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;

	public Member() {//매개변수 없는 생성자
	}

	public Member(String id, String pw, String name, String email,
					String address, String birth, char gender) {
		this.id = id;	//모든 매개변수 받는 생성자  
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	
	public String infoString() {  //메서드
		return "아이디 : "+ id+"\n" +
			   "비밀번호 : "+pw+"\n" +
			   "이름 : " +name+"\n" +
			   "이메일 : "+email+"\n" +
			   "주소 : "+ address+"\n" +
			   "생일 : "+birth +"\n"+
			   "성별 : "+gender; 
	}
	//id set&get
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	//pw set&get
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	//name set&get
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//email set&get
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//address set&get
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
