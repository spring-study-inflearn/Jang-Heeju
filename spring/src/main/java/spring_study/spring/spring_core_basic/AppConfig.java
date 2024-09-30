package spring_study.spring.spring_core_basic;

import spring_study.spring.spring_core_basic.Discount.DiscountPolicy;
import spring_study.spring.spring_core_basic.Discount.FixDiscountPolicy;
import spring_study.spring.spring_core_basic.Discount.RateDiscountPolicy;
import spring_study.spring.spring_core_basic.Order.OrderService;
import spring_study.spring.spring_core_basic.Order.OrderServiceImpl;
import spring_study.spring.spring_core_basic.member.MemberRespository;
import spring_study.spring.spring_core_basic.member.MemberService;
import spring_study.spring.spring_core_basic.member.MemberServiceImpl;
import spring_study.spring.spring_core_basic.member.MemoryMemberRespository;

public class AppConfig {

    // 원래는 memberserviceimpl에서
    // private final MemberRespository memberRespository
    //            = new MemoryMemberRespository();
    // 저렇게 구현객체를 설정해줬다.
    // 이제는 생성자를 통해서 구현객체를 설정해줘서 impl이 인터페이스에만 의존할 수 있게 DIP 지키게 한다.
    // 이것이 생성자 주입. .
    public MemberService memberService(){
        return new MemberServiceImpl
                (memberRespository());
    }

    // 리턴타입이 역할, 리턴하는게 구현클래스
    private MemberRespository memberRespository() {
        return new MemoryMemberRespository();
    }

    // 여기서는 쓸 구현체를 명시해서 넣어주고 원래의 orderservicimple에서는
    // 부모의(?) 타입으로 해서 넘겨주기, 인터페이스에만 의존할 수 있게
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRespository(),
                discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
