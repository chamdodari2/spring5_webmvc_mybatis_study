package spring5_webmvc_mybatis_study.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;

public class MemberListPrinter {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberPrinter printer;

	
//	public MemberListPrinter() {
//		// TODO Auto-generated constructor stub
//	}
//	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
//		this.memberDao = memberDao;
//		this.printer =printer;
//	}
	public void printAll() {
		Collection<Member> members = memberMapper.selectAll();  //members가 멤버를 가지고있는 컬렉션인데 그걸 넘겨서
		members.forEach(m->printer.print(m));
	}

}
