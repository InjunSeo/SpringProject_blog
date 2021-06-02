package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;

import java.util.List;
import java.util.Optional;

public interface EssayService {
    Essay write(Essay essay);

    Essay edit(Long essayId, Essay essay);

    Essay delete(Essay essay);

    Essay countFavour(Essay essay);

    Optional<Essay> findById(long id);

    Optional<Essay> findByName(String writer);

    Optional<Essay> findByTitle(String title);

    List<Essay> findAll();

}
