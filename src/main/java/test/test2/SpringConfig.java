package test.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.test2.repostory.MemberRepository;
import test.test2.repostory.MemoryMemberRepository;
import test.test2.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }
}
