package oss.board.repository;

import org.springframework.stereotype.Repository;
import oss.board.domain.Member;

import java.util.*;

public class  MemoryMemberRepository implements MemberRepository {
    private  static Map<Long, Member> store = new HashMap<>();
    private  static long sequence =0L; // 0 1 2 를 만들어준다.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Id가 널이여도 감쌀 수있다. 그러면 클라이언트에서 뭘 할 수있다.
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
                .filter(member -> member.getName().equals(name)) // meber name 과 paramiter에서 들어간 값이 같은지 확인 한다.
                .findAny();// 찾으면 반환한다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 반환된값을 리스트로 만들어라.
    }
    public void clearStore(){
        store.clear();
    }

}
