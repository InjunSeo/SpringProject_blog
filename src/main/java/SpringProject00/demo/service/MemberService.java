package SpringProject00.demo.service;

import SpringProject00.demo.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    String join(Member member);

    Optional<Member> findByName(String name);

    Optional<Member> findById(String id);

    List<Member> findAll();
}

