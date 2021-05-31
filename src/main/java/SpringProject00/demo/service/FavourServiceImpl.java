package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import SpringProject00.demo.domain.Member;
import SpringProject00.demo.repository.MemoryFavouringRepository;

import java.util.List;

public class FavourServiceImpl implements FavourService {
    private final MemoryFavouringRepository favouringRepository;

    public FavourServiceImpl(MemoryFavouringRepository favouringRepository) {
        this.favouringRepository = favouringRepository;
    }

    @Override
    public String addWhoFavour(Favouring favouring) {
        favouringRepository.addWhoFavour(favouring);
        return favouring.getWhoFavour();
    }

    @Override
    public List findWhoFavouring(Essay essay) {
        return favouringRepository.findWhoFavouring(essay);
    }

    @Override
    public List<Essay> findAll(Member member) {
        return favouringRepository.findAll();
    }

    @Override
    public int countFavour(Essay essay) {
        List peopleWhoFavouring = favouringRepository.findWhoFavouring(essay);
        int size = peopleWhoFavouring.size();
        return size;
    }
}
