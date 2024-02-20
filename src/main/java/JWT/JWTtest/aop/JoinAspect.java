package JWT.JWTtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Aspect
@Component
public class JoinAspect {

    @AfterReturning(value = "execution(* JWT.JWTtest.service.JoinService.JoinProcess(..))", returning = "result")
    public void afterJoinProcess(JoinPoint joinPoint, Boolean result) throws Exception {
        if (result) {
            System.out.println("회원가입이 정상적으로 처리되었습니다.");
        }
        else{
            throw new Exception("회원가입 실패했습니다.");

        }
    }
}