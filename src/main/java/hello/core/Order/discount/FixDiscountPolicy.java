package hello.core.Order.discount;

import hello.core.Entity.Member;
import hello.core.memberEnum.Grade;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountAmount = 1000;
    private int OTTdiscountPirce = 500;



    public int Orderdiscount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? this.discountAmount : 0;
    }

    public int OTTDiscouunt(Member member, int OTTPrice) {
        if (member.getGrade() == Grade.VIP) {
            return this.OTTdiscountPirce * 3;
        } else if (member.getGrade() == Grade.SUPER) {
            return this.OTTdiscountPirce * 2;
        } else {
            return member.getGrade() == Grade.GREATER ? this.OTTdiscountPirce * 1 : 0;
        }
    }
}