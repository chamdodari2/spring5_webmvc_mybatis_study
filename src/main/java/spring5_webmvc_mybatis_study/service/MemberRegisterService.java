package spring5_webmvc_mybatis_study.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.mapper.MemberMapper;

@Service
public class MemberRegisterService {

   
   @Autowired
   MemberMapper memberMapper;

   public MemberRegisterService(MemberMapper memberMapper){
      this.memberMapper = memberMapper;
   }
   
   public Long regist(RegisterRequest req) {
      Member member = memberMapper.selectByEmail(req.getEmail());
      if(member != null) {
         throw new DuplicateMemberException("dup email" +req.getEmail());
      }
      
      Member newMember = new Member(req.getEmail(), req.getPassword(),
            req.getName(), LocalDateTime.now());
      memberMapper.insert(newMember);
      return newMember.getId();
      
   }
}