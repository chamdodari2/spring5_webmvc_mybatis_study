package spring5_webmvc_mybatis_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 스프링MVC에서 컨트롤러로 사용
public class HelloController {
	@GetMapping("/hello")  //주소에 hello가 들어오면 처리해서 보여줄겡
	public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
		//1.요 매개변수 안에는 모델, 모델있으면 requestParam해온다.
		
		//2.파라미터로 온 값을 담기
		model.addAttribute("greeting", "안녕하세요, " + name);	 //“greetring”이라는 모델 속성에 값을 설정 JSP 코드는 이 속성을 이용해서 값을 출력
		return "hello"; // 컨트롤러의 처리 결과를 보여줄 뷰 이름으로 “hello”를 사용
	}
}
