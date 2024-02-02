package hello.core.service;

import hello.core.Entity.Member;
import hello.core.Entity.Order;
import hello.core.Order.discount.DiscountPolicy;
import hello.core.Repository.Repository.Memberrepository;

public class OrderServiceImpl implements OrderService {
    private final Memberrepository memberrepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(Memberrepository memberrepository, DiscountPolicy discountPolicy) {
        this.memberrepository = memberrepository;
        this.discountPolicy = discountPolicy;
    }

    public Order createOrder(Long memberId, String itemName, int iTemPrice, int discount) {
        Member byId = memberrepository.findById(memberId);
        int discountPrice = discountPolicy.Orderdiscount(byId, iTemPrice);
        return new Order(memberId, itemName, iTemPrice, discountPrice);
    }

    public Memberrepository getordererrepository()
    {
        return memberrepository;
    }
}