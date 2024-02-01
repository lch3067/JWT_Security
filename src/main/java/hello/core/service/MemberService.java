package hello.core.service;

import hello.core.Entity.Member;
import java.util.Map;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);

    Map<Long, Member> findAllMember();
}
