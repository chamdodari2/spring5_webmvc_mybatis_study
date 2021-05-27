package spring5_webmvc_mybatis_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.service.MemberRegisterService;
import spring5_webmvc_mybatis_study.service.RestMemberService;

@RestController
public class RestMemberController {
	@Autowired
	private RestMemberService restMemberService;
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	

	@GetMapping("/api/members")
	public List<Member> members() {
		return restMemberService.showMembers();
	}

	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = restMemberService.showMemberById(id);
		if (member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}
	///json형식의 데이터를 자바형식으로 수정해서 (Post)

	@PostMapping("/api/members")
	public void newMember(@RequestBody  RegisterRequest regReq, Errors errors, HttpServletResponse response) throws IOException {   //@Valid 필요없다. 벨리드 만들어서
			if(errors.hasErrors()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		try {
			Long newMemberId = memberRegisterService.regist(regReq);
			response.setHeader("Location", "/api/members/" + newMemberId);  //헤더에 알려주는것. 추가된 아이디를 응답코드로 알려줌
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (DuplicateMemberException e) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
	}
}



















