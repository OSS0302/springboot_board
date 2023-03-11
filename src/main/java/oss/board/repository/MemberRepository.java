package oss.board.repository;

import oss.board.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 아이디를 저장소에 저장

    Optional<Member> findById(Long id); // 회원 아이디를 찾겠다

    Optional<Member> findByName(String name); //회원의 이름를 찾겠다.

    List<Member> findAll();
    //회원 아이디를 리스트로 조회
    //Optioanl null일경우 처리해주겠다
}