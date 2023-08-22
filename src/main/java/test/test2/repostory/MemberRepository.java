package test.test2.repostory;

import test.test2.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByname(String name);
    List<Member> findAll();
}
