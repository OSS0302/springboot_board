package oss.board.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import oss.board.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach // 메서드 데스트 데이터를 한개씩 끝나면 실행되며 클리어 해주는  콜백매서드
    public void afterEach(){
    repository.clearStore();
    }


    @Test
    public void save(){
    Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);


        //System.out.println("result = " + (result == member)); // 내가 새로 만든 것과 db에있느것이 같은지를 확인한다.
        //Assertions.assertEquals(member, null);

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);
        //shift+F6 를 쓰면 쉽게 만든다.

        Member result = repository.findByName("Spring1").get();
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);
        List<Member>result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
        // 객체를 만들고 조회 했을때 갯수 같으면 통과 다르면 오류난다.
    }

}
 