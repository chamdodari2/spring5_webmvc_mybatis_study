package spring5_webmvc_mybatis_study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션제거하고
		return"redirect:/main";//메인으로 쫓아낸당
	}

}
