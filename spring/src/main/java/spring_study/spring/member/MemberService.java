package spring_study.spring.member;

public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}
