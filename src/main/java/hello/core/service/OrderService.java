package hello.core.service;

import hello.core.Entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int iTemPrice, int discount);
}
