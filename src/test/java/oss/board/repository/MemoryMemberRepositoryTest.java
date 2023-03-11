package oss.board.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import oss.board.domain.Member;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
    Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result == member)); // 내가 새로 만든 것과 db에있느것이 같은지를 확인한다.
        Assertions.assertEquals(member, result);
    }
}
 