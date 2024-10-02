package spring_study.spring.member;

public interface MemberRespository {

    void save(Member member);
    Member findById(Long memberId);

}
