package hello.core.Order.discount;

import hello.core.Entity.Member;
import hello.core.memberEnum.Grade;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    public int Orderdiscount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * this.discountPercent / 100 : 0;
    }

    public int OTTDiscouunt(Member member, int OTTPrice) {
        return 0;
    }
}