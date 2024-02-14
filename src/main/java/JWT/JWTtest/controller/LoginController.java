package JWT.JWTtest.controller;


import JWT.JWTtest.dto.JoinDto;
import JWT.JWTtest.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private final CustomUserDetailsService userDetailService;

    public LoginController(CustomUserDetailsService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/login")
    public String loginp(HttpServletResponse response, Authentication authentication){

        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");

        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            // 이미 인증된 사용자는 홈 페이지로 리다이렉션
            return "redirect:/";
        }
        // 인증되지 않은 사용자는 로그인 페이지를 보여줌
        return "login";
    }


}
