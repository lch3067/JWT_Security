package hello.core.Discount.ConfigurationBeanStorageTest;

//import hello.core.config.AppConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// 객체들이 빈 컨테이너에 담기다는것 하나
// 그 다음것을 조회하여 확실히 담겨져 있다.
// 객체, 다른 것들이 의존되어 있다면, 같이 불러온다.
// beanDefinition에 메타정보 생성함

public class BeanBasicFindTest {


    //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//    @Test
//    @DisplayName("빈 조회")
//    @Disabled
//    public void BeenShowTest()
//    {
//
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for(String been : beanDefinitionNames)
//        {
//            System.out.println(been);
//        }
//
//
//    }
}
