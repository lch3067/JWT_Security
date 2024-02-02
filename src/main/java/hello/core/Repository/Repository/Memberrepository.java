package hello.core.Repository.Repository;

import hello.core.Entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;


public interface Memberrepository {
    void save(Member member);

    Member findById(Long memberId);

    Map<Long, Member> findByAll();
}
