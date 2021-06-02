package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import SpringProject00.demo.repository.MemoryFavouringRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.spliterator;
import static org.junit.jupiter.api.Assertions.*;

class FavourServiceImplTest {

    MemoryFavouringRepository favouringRepository = new MemoryFavouringRepository();
    FavourService favourService = new FavourServiceImpl(favouringRepository);

    @AfterEach
    void afterEach() {
        favouringRepository.clear();
    }

    @Test
    void add(){
        Essay essay = new Essay("Seo", "IBE", "Infer to the best explanation");
        essay.setId(new Long(1));
        essay.setWriter("seomoon");
        Favouring favouring = new Favouring();
        favouring.setEssayId(essay.getId());
        favouring.setWhoFavour("seomoon");
        favourService.addWhoFavour(favouring);
        List peopleWhoFavour = favourService.findWhoFavouring(essay);
        assertThat(peopleWhoFavour).contains(favouring);
    }

    @Test
    void findPeopleWhoFavour() {
        Essay essay = new Essay("Seo", "IBE", "Infer to the best explanation");
        essay.setId(new Long(1));
        essay.setWriter("seomoon");
        Favouring favouring = new Favouring();
        favouring.setEssayId(essay.getId());
        favouring.setWhoFavour("seomoon");
        Favouring favouring2 = new Favouring();
        favouring2.setEssayId(essay.getId());
        favouring2.setWhoFavour("ubersky");
        favourService.addWhoFavour(favouring);
        favourService.addWhoFavour(favouring2);
        List peopleWhoFavour = favourService.findWhoFavouring(essay);
        assertThat(peopleWhoFavour.size()).isEqualTo(2);
    }

    @Test
    void countFavour(){
        Essay essay = new Essay("Seo", "IBE", "Infer to the best explanation");
        essay.setId(new Long(1));
        essay.setWriter("seomoon");
        Favouring favouring = new Favouring();
        favouring.setEssayId(essay.getId());
        favouring.setWhoFavour("seomoon");
        Favouring favouring2 = new Favouring();
        favouring2.setEssayId(essay.getId());
        favouring2.setWhoFavour("ubersky");
        favourService.addWhoFavour(favouring);
        favourService.addWhoFavour(favouring2);
        int countFavour = favourService.countFavour(essay);
        assertThat(countFavour).isEqualTo(2);
    }


}