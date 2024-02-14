package JWT.JWTtest.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


// DTO : 프로세스 간에 데이터를 전달하는 객체를 의미
// Dto를 통해서 추가적으로 @RequestParam("email")를 해줄 필요 없다. 한번에 객체를 넘기는 것(변경 없음(X))
// 객체라서 그 안에 비즈니스 로직 같은 복잡한 코드는 없고 순수하게 전달하고 싶은 데이터만 담

// 비즈니스 로직이란, 애플리케이션의 핵심적인 기능을 수행하는 로직
@Getter
@Setter
public class JoinDto {

    private String Stride;
    private String username;
    private String password;
    private String email;

}
