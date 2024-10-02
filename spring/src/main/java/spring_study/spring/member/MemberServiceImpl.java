package spring_study.spring.member;

public class MemberServiceImpl implements MemberService{

    // fianl을 붙이면 npe 없애기 위해 구현체도 설정해줘야한다.
//    private final MemberRespository memberRespository
//            = new MemoryMemberRespository();
    private MemberRespository memberRespository;

    public MemberServiceImpl(MemberRespository memberRespository){
        this.memberRespository=memberRespository;
    }
    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
