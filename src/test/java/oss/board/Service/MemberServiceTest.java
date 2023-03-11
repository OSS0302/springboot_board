package oss.board.Service;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import oss.board.domain.Member;
import oss.board.repository.MemberRepository;
import oss.board.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach  // 디펜던시 인젝션 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉
    public void before(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }



    @AfterEach // 메서드 데스트 데이터를 한개씩 끝나면 실행되며 클리어 해주는  콜백매서드
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void 회원가입(){
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //than
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e ){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
//        }


        //than
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}