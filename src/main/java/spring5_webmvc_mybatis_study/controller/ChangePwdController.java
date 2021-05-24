package spring5_webmvc_mybatis_study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_webmvc_mybatis_study.dto.AuthInfo;
import spring5_webmvc_mybatis_study.dto.ChangePwdCommand;
import spring5_webmvc_mybatis_study.dto.ChangePwdCommandValidator;
import spring5_webmvc_mybatis_study.exception.WrongIdPasswordException;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.ChangePasswordService;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private ChangePasswordService changePasswordService; //원래 service

	@GetMapping
	public String form(@ModelAttribute("command") ChangePwdCommand pwdCommand) {
		return "edit/changePwdForm";//폴더명, jsp파일명
	}

	@PostMapping
	public String submit(@ModelAttribute("command") ChangePwdCommand pwdCommand, Errors errors, HttpSession session) {
		new ChangePwdCommandValidator();
		if (errors.hasErrors())
			return "edit/changePwdForm"; //폴더명, jsp파일명
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(authInfo.getEmail(), pwdCommand.getCurrentPassword(),
					pwdCommand.getNewPassword());
			return "edit/changedPwd";  //폴더명, jsp파일명
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}
}
