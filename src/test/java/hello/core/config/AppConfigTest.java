package hello.core.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Config에 각기 스프링 컨테이너 싱글 톤 비교")
    void Configtest()
    {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String been : beanDefinitionNames)
        {
            System.out.println(been);
        }
    }


}