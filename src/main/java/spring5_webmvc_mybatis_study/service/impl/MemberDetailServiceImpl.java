package spring5_webmvc_mybatis_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;
import spring5_webmvc_mybatis_study.service.MemberDetailService;
@Service
public class MemberDetailServiceImpl implements MemberDetailService {
	@Autowired
	private MemberMapper memberMapper; //맨 처음에 메서드를 선언한곳
	@Override
	public Member showMemberById(Long memId) {//두번쨰로 선언한곳(서비스). 맨처음에 선언한곳꺼를 붙여주고 진짜 impl은 xml에서 작성
		
		return memberMapper.selectMemberById(memId);
	}

}
