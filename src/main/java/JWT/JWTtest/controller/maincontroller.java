package JWT.JWTtest.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class maincontroller {


    @GetMapping("/")
    public String mainP(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = authentication != null && !(authentication instanceof AnonymousAuthenticationToken);

        if (isAuthenticated) {
            // 사용자가 인증된 경우, 모델에 추가 정보를 넣거나 특정 로직을 수행
            model.addAttribute("isAuthenticated", true);
            // 예: 사용자 이름 추가
            model.addAttribute("username", authentication.getName());
        } else {
            // 사용자가 인증되지 않은 경우, 필요한 경우 처리
            model.addAttribute("isAuthenticated", false);
        }



        return "main";
    }
}
