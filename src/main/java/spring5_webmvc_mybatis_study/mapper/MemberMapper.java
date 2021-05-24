package spring5_webmvc_mybatis_study.mapper;

import java.util.List;

import spring5_webmvc_mybatis_study.dto.Member;

public interface MemberMapper {
	
	//멤버 전체 검색 (번호,멤버이름)?
	public List<Member> selectAll();
	//email로 검색
	Member selectByEmail(String email);
	//멤버 수 카운트
	Member count();
	int insert(Member member);
	public void update(Member member);
	
	
	
	
	
	
	
	//멤버 업데이트
//	Member update(Member member);
//	//멤버삭제
//	Member delete(Member member);
//	
//	//여러개의 입력 파라미터 전달
//	Member selectMemberByMap(Map<String,String> map);
//	
////	/ResultSet 처리방식 재정의
//	Map<Integer,Member> selectMemberForMap(Member member);
//	
//	

}
