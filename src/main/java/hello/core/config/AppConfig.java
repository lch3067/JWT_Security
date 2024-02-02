package hello.core.config;

import hello.core.Order.discount.DiscountPolicy;
import hello.core.Order.discount.FixDiscountPolicy;
import hello.core.Order.discount.RateDiscountPolicy;
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




//2024-02-01
// 지속적인 고객의 Request로 인해 서버 부하 발생가능
// 싱글톤 패턴 하여 개선하는 중
// 개선 방법
// 하나의 객체를 생성해서 공유하게끔 하는 방법으로 가면됩니다.
// Spring 컨테이너에 싱글톤이 이미 적용되어있음
    // Spring 컨테이너를 싱글톤 컨테이너라고도 함

@Configuration
public class AppConfig {

    // 만약 싱글톤을 만든다면, 다음과 같습니다.
    /*private static final AppConfig instance = new AppConfig();

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return instance;
    }*/

    // 하지만, 위코드를 사용하지 않는 이유 : 이미 싱글톤 패턴을 적용하여 spring에서 관리해줍니다.


    // 여기서 궁금한 점
    // memberService -> memberrepository() 호출하는 것
    // orderService -> memberrepository() 호출
    // 이미 memberrepository를 호출하였는데, 왜? 또 다른 것을 호출하는 것인지? 제대로 호출 되는 것인지 궁금함
    // AppConfigTest로 테스트 진행
    @Bean
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

    // static을 사용하게 되면, 싱글톤 영향을 줌
    // static의 성격 전역으로 공유함 하지만 싱글톤의 성격 한개의 클래스 메소드로 여러 객체를 관리함
    /*  @Bean
        private static Memberrepository memberrepository() {
            return new MemoryMemberRepository();
        }

        @Bean
        public static DiscountPolicy discountPolicy() {
            return new RateDiscountPolicy();
    }*/
    @Bean
    public Memberrepository memberrepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
