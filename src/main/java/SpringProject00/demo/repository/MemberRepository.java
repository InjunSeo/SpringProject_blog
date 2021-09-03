package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByName(String name);

    Member findById(String id);

    List<Member> findAll();


}
