package JWT.JWTtest;

import JWT.JWTtest.Entity.User;
import JWT.JWTtest.dto.PostDto;
import JWT.JWTtest.repository.Userrepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class memberTest {

    private final Userrepository userrepository;

    @Autowired
    public memberTest(Userrepository userrepository) {
        this.userrepository = userrepository;
    }

    @Test
    public void testView()
    {
        List<User> allDesc = userrepository.findAllDesc();
        for(User one : allDesc)
        {
            System.out.println(one);
        }
    }


}
