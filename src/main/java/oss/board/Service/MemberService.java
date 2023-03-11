package oss.board.Service;

import oss.board.domain.Member;
import oss.board.repository.MemberRepository;
import oss.board.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    //Member member1 = result.get(); 겟으로 해서 직접 뽑아낼 수있지만 권장하지 않는다.
    public Long join(Member member){
        // 중복되는 이름이 있으면 안된다
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(member1 -> {
                throw new IllegalStateException("이미존재하는 회원입니다.");
                });
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();

    }
    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);

    }

}
