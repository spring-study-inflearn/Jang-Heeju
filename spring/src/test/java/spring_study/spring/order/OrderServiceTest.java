package spring_study.spring.order;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_study.spring.AppConfig;
import spring_study.spring.Order.Order;
import spring_study.spring.Order.OrderService;
import spring_study.spring.member.Grade;
import spring_study.spring.member.Member;
import spring_study.spring.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;//= new MemberServiceImpl();
    OrderService orderService;// = new OrderServiceImpl();

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
