package test.test2.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.test2.domain.Member;
import test.test2.repostory.MemberRepository;
import test.test2.repostory.MemoryMemberRepository;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 변수 리셋 필요
    public void afterEach()
    {
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("test");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("returt = " + (result == member));
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        Member result = repository.findByname("test1").get();

        System.out.println("result = " + (result==member1));
        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findALL(){
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        System.out.println(result.size() == 2);
    }
}
