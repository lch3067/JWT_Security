package hello.core.Discount;

import hello.core.Entity.Member;
import hello.core.Entity.Order;
import hello.core.config.AppConfig;
import hello.core.memberEnum.Grade;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OTTService;
import hello.core.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
public class test {

//    MemberService memberService;
//    OrderService orderService;
//    OTTService ottService;
//    @BeforeEach
//    public void beforeEach()
//    {
//        AppConfig configuration = new AppConfig();
//        memberService = configuration.memberService();
//        orderService = configuration.orderService();
//        ottService = configuration.ottService();
//    }


//    @Test
//    void discount()
//    {
//
//        Member member = new Member(23L, "이충현", Grade.VIP);
//        memberService.join(member);
//        Member member1 = memberService.findMember(member.getId());
//        assertThat(member1.getName()).isEqualTo(member.getName());
//
//        Order order = orderService.createOrder(member1.getId(), "샴프", 4000, 1000);
//
//        System.out.println(order.toString());
//        System.out.println("할인된 가격은 : " + order.CalculationDiscountPirce());
//
//    }

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("test", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
    @Test
    void SpringbootTest()
    {
        Member member = new Member(23L, "이충현", Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(member.getId());
        assertThat(member1.getName()).isEqualTo(member.getName());
        System.out.println(member1.getName());

        Order order = orderService.createOrder(member1.getId(), "샴프", 4000, 1000);
        System.out.println(order.toString());
        System.out.println("할인된 가격은 : " + order.CalculationDiscountPirce());
    }

    @Test
    @DisplayName("이름 조회")
    public void FindByName()
    {
       //MemberService memberService = applicationContext.getBean("test", MemberService.class);
        MemberService memberService = applicationContext.getBean(MemberService.class);
        Member member = new Member(23L, "이충현", Grade.VIP);
        memberService.join(member);
        Member member1 = memberService.findMember(23L);
        System.out.println(member1.getName());


        assertThat(memberService).isInstanceOf(MemberService.class);

    }

    @Test
    @DisplayName("타입조회")
    public void FindByNameTypeCheck()
    {
        MemberServiceImpl memberService = applicationContext.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
