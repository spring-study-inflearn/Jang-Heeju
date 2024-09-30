package spring_study.spring.spring_core_basic.Order;

import spring_study.spring.spring_core_basic.AppConfig;
import spring_study.spring.spring_core_basic.member.Grade;
import spring_study.spring.spring_core_basic.member.Member;
import spring_study.spring.spring_core_basic.member.MemberService;
import spring_study.spring.spring_core_basic.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        // appconfig로 memberservice와 orderservice 만들기
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+order);

    }
}
