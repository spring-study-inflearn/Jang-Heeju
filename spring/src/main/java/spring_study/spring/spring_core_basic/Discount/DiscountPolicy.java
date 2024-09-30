package spring_study.spring.spring_core_basic.Discount;

import spring_study.spring.spring_core_basic.member.Member;

public interface DiscountPolicy {
    // return 할인 대상 금액
    int discount(Member member, int price);
}
