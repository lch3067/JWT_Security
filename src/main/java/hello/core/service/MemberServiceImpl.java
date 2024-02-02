package hello.core.service;

import hello.core.Entity.Member;

import hello.core.Repository.Repository.Memberrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component

public class MemberServiceImpl implements MemberService {
    private final Memberrepository memberrepository;

    @Autowired
    public MemberServiceImpl(Memberrepository memberrepository) {
        this.memberrepository = memberrepository;
    }


    @Override
    public void join(Member member) {
        this.memberrepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return this.memberrepository.findById(memberId);
    }
    @Override
    public Map<Long, Member> findAllMember() {
        return this.memberrepository.findByAll();
    }

    public Memberrepository getmemberrepository()
    {
        return memberrepository;
    }
}
