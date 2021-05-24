package spring5_webmvc_mybatis_study.dto;

public class LoginCommand { //로그인 폼에 입력한 값을 전달받기 위한 dto member와 같은 테이블 사용하지만 용도에 따라 새로만든거당
	private String email;
	private String password;
	private boolean rememberEmail;

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

	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}

	@Override
	public String toString() {
		return String.format("LoginCommand [email=%s, password=%s]", email, password);
	}
	
}
