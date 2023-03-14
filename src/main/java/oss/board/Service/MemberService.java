package oss.board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import oss.board.domain.Member;
import oss.board.repository.MemberRepository;
import oss.board.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
@Transactional // 항상 JPA를 쓰라면 @Transactional annotation을  데이터 변경하거나 저장 할 때사용된다..
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    //Member member1 = result.get(); 겟으로 해서 직접 뽑아낼 수있지만 권장하지 않는다.
    public Long join(Member member){

        long start = System.currentTimeMillis(); // 시작 시간 측정 밀리단위
        try{
            // 중복되는 이름이 있으면 안된다
            validateDuplicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis(); // 끝 시간 측정 밀리단위
           long timeMs= finish-start;
           System.out.println("join ="+timeMs+"ms");
        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(member1 -> {
                throw new IllegalStateException("이미존재하는 회원입니다.");
                });
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        long start = System.currentTimeMillis(); // 시작 시간 측정 밀리단위
        try{
            return memberRepository.findAll();

        }finally {
            long finish = System.currentTimeMillis(); // 끝 시간 측정 밀리단위
            long timeMs= finish-start; // 걸린시간:끝난 시간- 시작 시간 하면 걸린시간이 나온다.
            System.out.println("findMembers"+timeMs+"ms");
        }


    }
    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);

    }

}
