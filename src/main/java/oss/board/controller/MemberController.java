package oss.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import oss.board.Service.MemberService;
import oss.board.domain.Member;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String creaeForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); // 이름 가져와라
        memberService.join(member); // 회원가입 이름을 넘겨줘라.

        System.out.println("member.getName() = " + member.getName());
        return "redict:/"; // 회원 가입이 끝나면 홈 화면으로 보여줘라
    }

}
