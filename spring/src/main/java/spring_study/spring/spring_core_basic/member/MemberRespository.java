package spring_study.spring.spring_core_basic.member;

public interface MemberRespository {

    void save(Member member);
    Member findById(Long memberId);

}
