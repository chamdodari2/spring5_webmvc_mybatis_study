package spring5_webmvc_mybatis_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.exception.MemberNotFoundException;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberMapper memberMapper;  //메서드 맨처음 선언한 dao

	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id") Long memId) {
		Member member = memberMapper.selectMemberById(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
	}
	

	//회원조회에서 예외처리할거
	//방법2.
	//@ControllerAdvice 사용하면 ExceptionHandler는 지역익셉션(먼저처리하고, 여기서 처리 못하면 전역익셉션@ControllerAdvice에서 처리)
	//  --> 화면핸들러에서 밑에부분 지우고, 익셉션핸들러 따로 하나 만들어서 처리하기
	
	
//	//방법1 여기서 적고  jsp 화면 두개 만들기
//	@ExceptionHandler(TypeMismatchException.class) //네가 처리해준다음 저쪽 페이지로 보내조  //int 타입아니면
//	public String  handleTypeMismatchException() {
//		return"member/invalidId"; 
//	}
//	
//	@ExceptionHandler(MemberNotFoundException.class) //얘는 내가 작성한 익셉션이당!! 멤버 없으면 해당메세지 띄우고 저쪽 화면으로 보내조
//	public String handeMemberNotFoundException() {
//		return "member/noMember";
//	}
}
