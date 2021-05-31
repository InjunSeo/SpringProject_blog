package SpringProject00.demo.service;

import SpringProject00.demo.domain.Member;
import SpringProject00.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
    MemberServiceImpl memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    public void join() {
        Member member = new Member();
        member.setId("seomoon");
        member.setName("seo");
        String join = memberService.join(member);
        Member findMember = memberRepository.findById(join).get();
        assertEquals(member.getId(), findMember.getId());
    }
    @Test
    public void validate() {
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setId("seomoon");
        member1.setName("seo");
        member2.setId("seomoon");
        member2.setName("park");
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("Already existing ID");
    }
}