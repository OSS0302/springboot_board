package oss.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import oss.board.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{
    //인터페이스는 다중 상속이 가능하다 클래스:implements  을 쓰고 인터페이스: extends을 쓴다.
    @Override
    Optional<Member> findByName(String name);// 이게 끝이다. 구현을 안해도 된다.

}
