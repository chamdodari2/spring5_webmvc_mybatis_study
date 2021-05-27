package spring5_webmvc_mybatis_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.RestMemberService;
@Service
public class RestMemberServiceImpl implements RestMemberService {
	@Autowired
    private MemberMapper memberMapper;
	//private MemberDetailService memberDetailService;
	
	

	@Override
	public Member showMemberById(Long memId) { //id검색이랑
		return memberMapper.selectMemberById(memId);
	}

	@Override
	public List<Member> showMembers() {  //모든멤버
		return memberMapper.selectAll();
	}

}
