package hello.core.Discount.SingleToneTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


import static org.assertj.core.api.Assertions.*;

class StatefullserviceTest {
    @Test
    void statefullserviceTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        Statefullservice User1 = ac.getBean(Statefullservice.class);
        Statefullservice User2 = ac.getBean(Statefullservice.class);

        assertThat(User1).isEqualTo(User2);

        int one = User1.StatuesOrder("이충현", 2000);


        System.out.println(one);


        int twe = User2.StatuesOrder("김성일", 1000);

        // 분명히 나는 User1의 데이터를 가져오고 싶은데, 싱글톤 때문에 값이 김성일, 1000값으로 초기화됨
        // 즉, 객체 하나 생성으로 가져오는 방식의 취약점
        // 값이 변경되는 것이 문제

        System.out.println(twe);

    }


    static class TestConfig {
        @Bean
        public Statefullservice statefullservice(){
            return new Statefullservice();
        }
    }

}