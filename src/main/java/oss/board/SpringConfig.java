package oss.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oss.board.Service.MemberService;
import oss.board.repository.MemberRepository;
import oss.board.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
