package spring_study.spring.spring_core_basic.member;

import spring_study.spring.spring_core_basic.AppConfig;
import spring_study.spring.spring_core_basic.member.Grade;
import spring_study.spring.spring_core_basic.member.Member;
import spring_study.spring.spring_core_basic.member.MemberService;
import spring_study.spring.spring_core_basic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
        // memorymemberrepository 쓸거라고 함
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);;

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+ findMember.getName());;
    }
}
