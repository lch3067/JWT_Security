package hello.core.Repository.Repository;

import hello.core.Entity.Member;
import java.util.Map;

public interface Memberrepository {
    void save(Member member);

    Member findById(Long memberId);

    Map<Long, Member> findByAll();
}
