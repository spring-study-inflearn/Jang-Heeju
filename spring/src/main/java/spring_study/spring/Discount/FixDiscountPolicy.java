package spring_study.spring.Discount;

import spring_study.spring.member.Grade;
import spring_study.spring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){ // enum은 ==으로 비교가 맞음
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
