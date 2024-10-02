package spring_study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_study.spring.Order.Order;
import spring_study.spring.Order.OrderService;
import spring_study.spring.member.Grade;
import spring_study.spring.member.Member;
import spring_study.spring.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
        // appconfig로 memberservice와 orderservice 만들기
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = "+order);

    }
}
