package hello.core.Discount.ConfigurationBeanStorageTest;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// 전체 빈 조회해보기
// 빈 컨테이너에 담긴 객체들 조회하기
public class BeanCheckTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("모든 빈 출력하기1")
    public void BeacntestFucntion(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames)
        {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println(bean);
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기2")
    public void BeacntestFucntion2(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames)
        {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
            {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println(bean);
                System.out.println(beanDefinitionName);
            }
        }
    }
}
