package spring_study.spring.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRespository implements MemberRespository{

    // concurency hashmap으로 해야 동시성 이슈 해결할 수 있다? 실무에선 이거 씀
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
