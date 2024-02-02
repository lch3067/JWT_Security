package hello.core.Order.discount;

import hello.core.Entity.Member;
import org.springframework.stereotype.Component;


public interface DiscountPolicy {
    int Orderdiscount(Member member, int price);

    int OTTDiscouunt(Member member, int OTTPrice);
}
