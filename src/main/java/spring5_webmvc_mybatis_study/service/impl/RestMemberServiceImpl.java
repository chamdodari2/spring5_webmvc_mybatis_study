package spring5_webmvc_mybatis_study.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.RestMemberService;

@Service
public class RestMemberServiceImpl implements RestMemberService {
	@Autowired
	private MemberMapper memberMapper;
	// private MemberDetailService memberDetailService;

	@Override
	public Member showMemberById(Long memId) { // id검색이랑
		return memberMapper.selectMemberById(memId);
	}

	@Override
	public List<Member> showMembers() { // 모든멤버
		return memberMapper.selectAll();
	}

	@Override
	public Long regist(RegisterRequest regReq) {
		Member member = memberMapper.selectByEmail(regReq.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + regReq.getEmail());
		}
		Member newMember = new Member(regReq.getEmail(), regReq.getPassword(), regReq.getName(), LocalDateTime.now());
		memberMapper.insert(newMember);
		return newMember.getId();
	}

}
