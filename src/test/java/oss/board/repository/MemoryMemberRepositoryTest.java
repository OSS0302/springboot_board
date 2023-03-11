package oss.board.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import oss.board.domain.Member;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

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
}
 