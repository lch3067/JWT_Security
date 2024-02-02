package hello.core.config;

import hello.core.AutoConfigScan;
import hello.core.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoConfigScanTest {



    @Test
    void Basic()
    {



        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoConfigScan.class);

        applicationContext.getBean(MemberServiceImpl.class);
        //applicationContext.getBean(MemberService.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String been : beanDefinitionNames)
        {
            System.out.println(been);
        }

        //assertThat(memberService).isInstanceOf(MemberService.class);
    }

}