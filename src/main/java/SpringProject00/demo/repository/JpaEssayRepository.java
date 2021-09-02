package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class JpaEssayRepository implements EssayRepository {

    private final EntityManager em;

    @Override
    public Essay save(Essay essay) {
        em.persist(essay);
        return essay;
    }

    @Override
    public Essay modify(Long essayId, Essay updateParam) {
        return null;
    }

    @Override
    public Essay delete(Essay essay) {
        return null;
    }

    @Override
    public Essay countFavour(Essay essay) {
        return null;
    }

    @Override
    public Optional<Essay> findById(long id) {
        Essay essay = em.find(Essay.class, id);
        return Optional.ofNullable(essay);
    }

    @Override
    public Optional<Essay> findByName(String writer) {
        List<Essay> result = em.createQuery("select m from Essay m where m.member = :writer", Essay.class)
                .setParameter("writer", writer)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Essay> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<Essay> findAll() {
        return em.createQuery("select m from Essay m", Essay.class)
                .getResultList();
    }
}
