package JWT.JWTtest.service;

import JWT.JWTtest.Entity.User;
import JWT.JWTtest.dto.CustomUserDeatils;
import JWT.JWTtest.repository.Userrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private Userrepository userrepository;

    @Override
    public UserDetails loadUserByUsername(String Stride) throws UsernameNotFoundException {
        User user = userrepository.findByStride(Stride);
        if(user != null)
        {
            return new CustomUserDeatils(user);
        }
        return null;
    }
}
