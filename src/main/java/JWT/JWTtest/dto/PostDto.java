package JWT.JWTtest.dto;

import JWT.JWTtest.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PostDto {


    private String Stride;
    private String username;
    private String role;
    private String email;

    public PostDto(User user) {
        this.Stride = user.getStride();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.email = user.getEmail();
    }
}


