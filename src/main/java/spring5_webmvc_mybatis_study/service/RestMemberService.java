package spring5_webmvc_mybatis_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
@Service
public interface RestMemberService extends MemberDetailService {  //요고로 받아서
	List<Member> showMembers();
	Member showMemberById(Long memId);



}
