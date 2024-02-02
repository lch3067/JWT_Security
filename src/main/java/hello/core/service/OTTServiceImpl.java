package hello.core.service;

import hello.core.Entity.Member;
import hello.core.Entity.OTT;
import hello.core.Order.discount.DiscountPolicy;
import hello.core.Repository.Repository.Memberrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OTTServiceImpl implements OTTService {
    private final Memberrepository memberrepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OTTServiceImpl(Memberrepository memberrepository, DiscountPolicy discountPolicy) {
        this.memberrepository = memberrepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public OTT JoinOTT(Long memberId, String subject, int price, String kind, int discountPirce) {
        Member byId = this.memberrepository.findById(memberId);
        int dicountPrice = this.discountPolicy.OTTDiscouunt(byId, price);
        return new OTT(memberId, subject, price, kind, dicountPrice);
    }
    public Memberrepository getoottrrepository()
    {
        return memberrepository;
    }



}
