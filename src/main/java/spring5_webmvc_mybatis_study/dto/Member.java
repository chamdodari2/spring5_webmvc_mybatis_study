package spring5_webmvc_mybatis_study.dto;

import java.time.LocalDateTime;

import spring5_webmvc_mybatis_study.exception.WrongIdPasswordException;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	
	//id 빼놓고 네개만으로 만듬
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public void changePassword (String oldPassword, String newPassword){
		if(!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	////////////////입력받은 값이 회원가입시 저장된 패스워드와 일치하는지 확인
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

}
