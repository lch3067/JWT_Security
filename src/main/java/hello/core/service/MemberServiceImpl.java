package hello.core.service;

import hello.core.Entity.Member;
import hello.core.Repository.Repository.Memberrepository;
import java.util.Map;

public class MemberServiceImpl implements MemberService {
    private final Memberrepository memberrepository;

    public MemberServiceImpl(Memberrepository memberrepository) {
        this.memberrepository = memberrepository;
    }

    public void join(Member member) {
        this.memberrepository.save(member);
    }

    public Member findMember(Long memberId) {
        return this.memberrepository.findById(memberId);
    }

    public Map<Long, Member> findAllMember() {
        return this.memberrepository.findByAll();
    }
}
