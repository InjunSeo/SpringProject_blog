package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaEssayRepository implements EssayRepository {

    private final EntityManager em;

    public JpaEssayRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Essay save(Essay essay) {
        return null;
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
        return Optional.empty();
    }

    @Override
    public Optional<Essay> findByName(String writer) {
        return Optional.empty();
    }

    @Override
    public Optional<Essay> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<Essay> findAll() {
        return null;
    }
}
