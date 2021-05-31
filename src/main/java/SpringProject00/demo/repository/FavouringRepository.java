package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import SpringProject00.demo.domain.Member;

import java.util.List;

public interface FavouringRepository {
    Favouring addWhoFavour(Favouring favouring);

    List findWhoFavouring(Essay essay);

    List<Essay> findAll();
}
