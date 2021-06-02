package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface EssayRepository {
    Essay save(Essay essay);

    Essay modify(Long essayId, Essay updateParam);

    Essay delete(Essay essay);

    Essay countFavour(Essay essay);

    Optional<Essay> findById(long id);

    Optional<Essay> findByName(String writer);

    Optional<Essay> findByTitle(String title);

    List<Essay> findAll();

}
