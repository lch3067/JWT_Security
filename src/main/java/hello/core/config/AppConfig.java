package hello.core.config;

import hello.core.Order.discount.DiscountPolicy;
import hello.core.Order.discount.FixDiscountPolicy;
import hello.core.Repository.Repository.Memberrepository;
import hello.core.Repository.Repository.MemoryMemberRepository;
import hello.core.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 정보
// Configuration 환경설정, Bean 각기 객체를 관리(수동)
// 객체 관리
// 빈의 이름은 항상 다르게 설정(중복되면 에러 발생)
// xml, Appconfig.class 등 여러 방식이 존재함

// Component
@Configuration
public class AppConfig {


    @Bean(name = "test")
    public MemberService memberService() {
        return new MemberServiceImpl(memberrepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberrepository(), discountPolicy());
    }

    @Bean
    public OTTService ottService() {
        return new OTTServiceImpl(memberrepository(), discountPolicy());
    }

    @Bean
    private static Memberrepository memberrepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
