package JWT.JWTtest.service;

import JWT.JWTtest.Entity.User;
import JWT.JWTtest.dto.JoinDto;
import JWT.JWTtest.repository.Userrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// 가입을 위한 서비스

@Service
@RequiredArgsConstructor
public class JoinService {
    private final Userrepository userrepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 더 추가해야 할 메소드
        // 현재 회원이 존재하는지 파악하기?
        // 비밀번호 일치하는지?
    public Boolean JoinProcess(JoinDto joinDto){

        Boolean result = userrepository.existsByStride(joinDto.getStride());

        if (result) {
            return false;
        }
        else{
            User user = new User();
            user.setStride(joinDto.getStride());
            user.setUsername(joinDto.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
            user.setEmail(joinDto.getEmail());
            user.setRole("ROLE_USER");
            userrepository.save(user);
            return true;
        }
    }





}
