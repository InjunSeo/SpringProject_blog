package SpringProject00.demo.controller;

import SpringProject00.demo.domain.Member;
import SpringProject00.demo.service.MemberService;
import SpringProject00.demo.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }
}
