package test.test2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.test2.domain.Member;
import test.test2.repostory.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEash()
    {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach // 변수 리셋 필요
    public void afterEach()
    {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입()
    {
        // given
        Member member = new Member();
        member.setName("test");
        // when
        Long seveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(seveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외()
    {
        Member member1 = new Member();
        member1.setName("test");

        Member member2 = new Member();
        member2.setName("test");

        memberService.join(member1);

        // assertThrows(IllegalStateException.class, () -> memberService.join(member2));  == 예외 확인
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); // 예외 메세지 확인
        // memberService.join(member2);
    }
}
