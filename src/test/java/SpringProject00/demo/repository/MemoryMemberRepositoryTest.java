package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setId("seomoon");
        member.setName("Seo");
        repository.save(member);
        Member result = repository.findByName(member.getName()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setId("seomoon");
        member1.setName("Seo");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("seostar");
        member2.setName("Boot");
        repository.save(member2);

        Member result = repository.findByName(member1.getName()).get();
        System.out.println("result = " + result);;

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setId("seomoon");
        member1.setName("Seo");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("seostar");
        member2.setName("Boot");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}