package JWT.JWTtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String AdminP()
    {
        return "admin";
    }

}
