package JWT.JWTtest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 특정 경로는 허가, 특정 경로는 보안
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    // 암호화 시킨다.
    // Spring Container에 넣어두고 어디서든 사용가능하다.
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // 접근 허용
        // 상단부터 밑으로 순차적으로 적용됨 그래서 순서를 잘 지켜줘야함
        // 버전에 따라 내부 구현(로직)이 다르다.
        http
                .authorizeHttpRequests((auth) ->auth
                        // 회원가입하지않은 사람, 방문자 등 접근 가능
                        .requestMatchers("/", "/login", "/join","/joinProc").permitAll()
                        .requestMatchers("/admin", "/AllMember").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );







        // 로그인안된 상태로 admin 페이지로 가게되면, 자동으로 login 페이지로 감
        
        http
                .formLogin((auth) ->auth
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .usernameParameter("Stride") // 이 부분 추가
                        .permitAll()


                );


        http
                .logout((logout) -> logout
                .logoutUrl("/logout")

                .logoutSuccessHandler(((request, response, authentication) -> {
                    response.sendRedirect("/login");
                        }))
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")

                );




        HttpSecurity csrf = http
                .csrf(AbstractHttpConfigurer::disable);


        return http.build();
    }


}
