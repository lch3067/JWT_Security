package JWT.JWTtest;

import JWT.JWTtest.Entity.User;
import JWT.JWTtest.controller.JoinController;
import JWT.JWTtest.controller.LoginController;
import JWT.JWTtest.repository.Userrepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class testClase {


    @Autowired
    private Userrepository userrepository;


    @Test
    public void test()
    {



    }


}
