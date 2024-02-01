package hello.core.Discount;

import hello.core.config.AppConfig;
import hello.core.service.MemberService;
import hello.core.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;

public class ConfigTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("test", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
    @Test
    @DisplayName("싱글톤 테스트")
    void SingleTest()
    {
        //System.out.println(memberService);
        //System.out.println(orderService);
        // 서로 다른 객체 생성됨
        assertThat(memberService).isEqualTo(orderService);
    }




}