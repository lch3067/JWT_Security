package JWT.JWTtest.service;


import JWT.JWTtest.dto.PostDto;
import JWT.JWTtest.repository.Userrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final Userrepository userrepository;


    public List<PostDto> findAllDesc(){
        return userrepository.findAllDesc().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

}
