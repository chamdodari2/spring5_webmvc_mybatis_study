package spring5_webmvc_mybatis_study.exception;

public class DuplicateMemberException extends RuntimeException {
	
	public DuplicateMemberException(String message) {
		super(message);
	}

}
