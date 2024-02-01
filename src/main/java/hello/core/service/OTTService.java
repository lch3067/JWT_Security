package hello.core.service;

import hello.core.Entity.OTT;

public interface OTTService {
    OTT JoinOTT(Long memberId, String subject, int price, String kind, int discountPirce);
}
