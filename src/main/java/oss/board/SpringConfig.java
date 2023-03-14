package oss.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oss.board.Service.MemberService;
import oss.board.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    // db와 연동하기 위해서 데이터소스 만든후에 생성자 추가후 Autowired을 만든다. 20년전 방식
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    //@PersistenceContext 원래 스펙에서는 @PersistenceContext 써야되지만 스프링부트에서는 자동으로 의존성 주입이 됩니다.

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return  new JdbcMemberRepository(dataSource); 20년전 방식
//        return new JdbcTemplateMemberRepository(dataSource); //스프링 JdbcTemplate
//        return  new JPAMemberRepository(em); JPA
//    }
}
