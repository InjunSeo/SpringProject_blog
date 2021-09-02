package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import SpringProject00.demo.domain.Member;
import SpringProject00.demo.repository.FavouringRepository;
import SpringProject00.demo.repository.MemoryFavouringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavourServiceImpl implements FavourService {
    private final FavouringRepository favouringRepository;

    @Override
    public String addWhoFavour(Favouring favouring) {
        favouringRepository.addWhoFavour(favouring);
//        return favouring.getWhoFavour();
        return null;
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
