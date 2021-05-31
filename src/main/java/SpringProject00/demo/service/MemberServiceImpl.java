package SpringProject00.demo.service;

import SpringProject00.demo.domain.Member;
import SpringProject00.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member) {
        validateDuplicationMember(member);
        memberRepository.save(member);
        System.out.println("New joined member = " + member);
        return member.getId();
    }

    private void validateDuplicationMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("Already existing ID");
                });
    }

    public Optional<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

}
