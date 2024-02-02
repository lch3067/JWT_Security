package hello.core.Order.discount;

import hello.core.Entity.Member;
import hello.core.memberEnum.Grade;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    private int resultPrice = 0;
    public int Orderdiscount(Member member, int price) {
        switch (member.getGrade()) {
            case VIP:
                resultPrice = price - 100;
                break;
            case BASIC:
                resultPrice = price - 50;
                break;
            default:
                resultPrice = price - 10;
        }
        return resultPrice;
    }

    public int OTTDiscouunt(Member member, int OTTPrice) {
        return 0;
    }
}