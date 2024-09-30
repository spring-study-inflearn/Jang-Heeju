package spring_study.spring.spring_core_basic.Order;

import spring_study.spring.spring_core_basic.Discount.DiscountPolicy;
import spring_study.spring.spring_core_basic.Discount.FixDiscountPolicy;
import spring_study.spring.spring_core_basic.member.Member;
import spring_study.spring.spring_core_basic.member.MemberRespository;
import spring_study.spring.spring_core_basic.member.MemoryMemberRespository;

public class OrderServiceImpl implements OrderService{

    private final MemberRespository memberRespository; //= new MemoryMemberRespository();
    private final DiscountPolicy discountPolicy;// = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    public OrderServiceImpl(MemberRespository memberRespository,
                            DiscountPolicy discountPolicy){
        this.memberRespository = memberRespository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRespository.findById(memberId);
        // 단일책임원칙이 잘 지켜진 경우
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
