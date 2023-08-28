package test.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.test2.domain.Member;
import test.test2.repostory.MemberRepository;
import test.test2.repostory.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// @Service
//@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    // @Autowired // 의존 관계 부여
    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public long join(Member member)
    {
        // 중복 제외
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }
}
