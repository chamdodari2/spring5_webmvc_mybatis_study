package spring5_webmvc_mybatis_study.controller;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;

public class MemberInfoPrinter {
	
	private MemberMapper memberMapper;
	
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memberMapper.selectByEmail(email);
		if(member==null) {
			System.out.println("데이터 없음");
			return;
		}
		printer.print(member);
		System.out.println();
	}

//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
//
//	public void setPrinter(MemberPrinter printer) {
//		this.printer = printer;
//	}
//	
	
//85쪽 키포인트는 세터메소트
}
