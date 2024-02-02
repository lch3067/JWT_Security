package hello.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoConfigScan.class);



		//applicationContext.getBean(MemberService.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String been : beanDefinitionNames)
		{
			System.out.println(been);
		}
	}
}
