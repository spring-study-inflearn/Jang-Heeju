package spring_study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_study.spring.member.Grade;
import spring_study.spring.member.Member;
import spring_study.spring.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
        // memorymemberrepository 쓸거라고 함
        //MemberService memberService = appConfig.memberService();

        // appconfig에 있는 정보를 다 객체생성한걸 넣어 컨테이너에 넣어줌
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class );

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);;

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+ findMember.getName());;
    }
}
