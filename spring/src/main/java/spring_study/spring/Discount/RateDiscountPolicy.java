package spring_study.spring.Discount;

import spring_study.spring.member.Grade;
import spring_study.spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100; // 100을 왜 나누지
        } else {
            return 0;
        }
    }
}
