package spring5_webmvc_mybatis_study.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("spring5_webmvc_mybatis_study")//이 프로젝트 모든 패키지에 있는 익셉션 가져다쓸수있다!
public class CommonExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class) //얘가 처리하고
	public String handleRuntimeException() {	//저쪽화면으로 보내조
		return "error/commonException";
	}
	

}
