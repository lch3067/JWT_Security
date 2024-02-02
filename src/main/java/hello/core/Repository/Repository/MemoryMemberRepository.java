package hello.core.Repository.Repository;

import hello.core.Entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Component
@Repository
public class MemoryMemberRepository implements Memberrepository {
    private static Map<Long, Member> store = new HashMap();
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    public Member findById(Long memberId) {
        return (Member)store.get(memberId);
    }
    public Map<Long, Member> findByAll() {
        return store;
    }



}