package spring_study.spring.spring_core_basic.member;

public class MemberServiceImpl implements MemberService{

    // npe 없애기 위해 구현체도 설정해줘야한다.
    private final MemberRespository memberRespository
            = new MemoryMemberRespository();
    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
