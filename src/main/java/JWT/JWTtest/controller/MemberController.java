package JWT.JWTtest.controller;


import JWT.JWTtest.dto.PostDto;
import JWT.JWTtest.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final PostService postService;
    private final HttpSession httpSession;

    @GetMapping("/AllMember")
    public String AllMemberFind(Model model){
        List<PostDto> posts = postService.findAllDesc();

        model.addAttribute("posts", posts);
        return "Member";
    }


}
