package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void findOne() throws Exception {
        //given 주어졌을 때
        Member member = new Member("hello", 20);
        //when 실행했을 때
        Member savedMember = memberRepository.save(member);

        //then 이거야 해
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
     }

     @Test
     public void findAll() throws Exception {
         //given
         Member member1 = new Member("hello1", 20);
         Member member2 = new Member("hello2", 30);

         memberRepository.save(member1);
         memberRepository.save(member2);
         //when
         List<Member> result = memberRepository.findAll();

         //then
         assertThat(result.size()).isEqualTo(2);
         assertThat(result).contains(member1, member2);
      }
}