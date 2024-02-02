package hello.core.config;

import hello.core.Entity.Member;
import hello.core.Repository.Repository.Memberrepository;
import hello.core.memberEnum.Grade;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OTTServiceImpl;
import hello.core.service.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class AppConfigTest {



    // 분명히 스프링은 싱글톤을 사용하면서 싱글톤의 장점들을 보장해 준다고 했다.
    // 즉, 객체 하나 생성하여 돌려 쓴다고 했다. 근데, AppConfig를 보면 여러 중복된 객체를 사용한다는 점이 문제
    
    @Test
    @DisplayName("Config에 각기 스프링 컨테이너 싱글 톤 비교")
    void Configtest()
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberservice1 = applicationContext.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderservice1 = applicationContext.getBean(OrderServiceImpl.class);
        OTTServiceImpl ottService1 = applicationContext.getBean(OTTServiceImpl.class);

        Memberrepository memberepository = applicationContext.getBean(Memberrepository.class);

        Memberrepository getmemberrepository1 = memberservice1.getmemberrepository();
        Memberrepository getordererrepository1 = orderservice1.getordererrepository();
        Memberrepository getottserviceresptotr1 = ottService1.getoottrrepository();


//        System.out.println(getmemberrepository1);
//        System.out.println(getordererrepository1);
//        System.out.println(getottserviceresptotr1);
//        System.out.println(memberepository);

        // 3가지 주소값이 같음 그래서 싱글톤을 지키는 중입니다.
        assertThat(memberservice1.getmemberrepository()).isSameAs(memberepository);
        assertThat(orderservice1.getordererrepository()).isSameAs(memberepository);
        assertThat(ottService1.getoottrrepository()).isSameAs(memberepository);


        //assertThat(getmemberrepository).isEqualTo(getordererrepository);


    }


}