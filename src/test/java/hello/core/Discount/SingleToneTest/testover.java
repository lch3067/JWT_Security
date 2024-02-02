package hello.core.Discount.SingleToneTest;

import hello.core.Entity.Member;
import hello.core.Entity.Order;
import hello.core.config.AppConfig;
import hello.core.memberEnum.Grade;
import hello.core.service.MemberService;
import hello.core.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class testover {

    ApplicationContext AC = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = AC.getBean(MemberService.class);
    OrderService orderService = AC.getBean(OrderService.class);

    @Test
    @DisplayName("기존 Appconfing 객체 생성전과 후에 싱글톤 적용")
    void StingleToneContainer()
    {
        //AppConfig appConfig = new AppConfig();

        //memberService = appConfig.memberService();
        // 주소값이 같다.
        MemberService MS1 = AC.getBean(memberService.getClass());
        Member member1 = new Member(23L, "이충현", Grade.VIP);
        MS1.join(member1);

        MemberService MS2 = AC.getBean(memberService.getClass());
        Member member2 = new Member(24L, "이충현", Grade.BASIC);
        MS2.join(member2);


        // 그결과 Spring Boot에 싱글톤 방식으로 실행된다.

        //orderService = appConfig.orderService();


        //System.out.println(memberService);
        //System.out.println(orderService);
        //assertThat(memberService).isEqualTo(orderService);
        assertThat(MS1).isEqualTo(MS2);


        OrderService OS1 = AC.getBean(orderService.getClass());
        OrderService OS2 = AC.getBean(orderService.getClass());

        // 항상 Stateless 방식으로 개발하라, 공유필드는 조심해라

        // 여기의 문제점 A라는 유저가
        Order result1 = OS1.createOrder(member1.getId(), "숙주", 1500, 500);
        Order result2 = OS2.createOrder(member2.getId(), "가지", 1500, 500);

        // 1번 유저
        System.out.println("1번 유저");
        System.out.println(("상품 명 : " + result1.getItemName()));
        System.out.println(("상품 가격 : " + result1.getItemPrice()));
        System.out.println(("할인된 가격 : " + result1.getDiscountPirce()));
        System.out.println("할인가격 : " + result1.CalculationDiscountPirce());

        // 2번 유저
        System.out.println("2번 유저");
        System.out.println(("상품 명 : " + result2.getItemName()));
        System.out.println(("상품 가격 : " + result2.getItemPrice()));
        System.out.println(("할인된 가격 : " + result2.getDiscountPirce()));
        System.out.println("할인가격 : " + result2.CalculationDiscountPirce());

        // A 사용자와 B 사용자가 인스턴스가 같다. 같은 객체 생성으로[싱글톤의 문제]
        assertThat(OS1).isEqualTo(OS2);

    }

}
