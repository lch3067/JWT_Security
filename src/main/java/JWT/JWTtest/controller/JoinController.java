package JWT.JWTtest.controller;

import JWT.JWTtest.dto.JoinDto;
import JWT.JWTtest.service.JoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Time;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinp(){

        return "join";
    }

    // 가입하면 로그인 페이지로감
    // DTO : 프로세스 간에 데이터를 전달하는 객체를 의미
    // Dto를 통해서 추가적으로 @RequestParam("email")를 해줄 필요 없다. 한번에 객체를 넘기는 것(변경)
    // 객체라서 그 안에 비즈니스 로직 같은 복잡한 코드는 없고 순수하게 전달하고 싶은 데이터만 담
    @PostMapping("/joinProc")
    public String JoinProcess(JoinDto joinDto)  {

        Boolean result = joinService.JoinProcess(joinDto);
        if(result)
        {
            return "redirect:/SuccessfullJoin";
        }else{
            return "redirect:/join";
        }
    }

    @GetMapping("/SuccessfullJoin")
    public void SuccessfullJoin(JoinDto joinDto, Model model)
    {
        model.addAttribute("Coment",joinDto.getUsername() + "회원가입이 정상적으로 처리되었습니다.");
    }
}
