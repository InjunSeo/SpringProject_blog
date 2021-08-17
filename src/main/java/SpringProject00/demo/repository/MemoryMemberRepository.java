package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository {
    private static Map<String, Member> store = new HashMap<>();
    private static Date createDate;

    @Override
    public Member save(Member member) {

        member.setCreateDate(createDate);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
