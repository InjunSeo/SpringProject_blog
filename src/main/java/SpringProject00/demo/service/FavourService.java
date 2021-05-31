package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import SpringProject00.demo.domain.Member;

import java.util.List;

public interface FavourService {
    String addWhoFavour(Favouring favouring);

    List findWhoFavouring(Essay essay);

    List<Essay> findAll(Member  member);

    int countFavour(Essay essay);
}
