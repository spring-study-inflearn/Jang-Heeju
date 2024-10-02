package spring_study.spring.Order;

import spring_study.spring.Discount.DiscountPolicy;
import spring_study.spring.member.Member;
import spring_study.spring.member.MemberRespository;

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
