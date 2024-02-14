package JWT.JWTtest.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(unique = true)
    private String stride;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String role;
}
