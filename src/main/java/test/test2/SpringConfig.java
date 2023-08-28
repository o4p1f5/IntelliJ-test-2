package test.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.test2.repostory.JdbcTemplateMemberRepository;

import test.test2.repostory.MemberRepository;

import test.test2.service.MemberService;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em)
//    {
//        this.em = em;
//    }
    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);

    }
}
