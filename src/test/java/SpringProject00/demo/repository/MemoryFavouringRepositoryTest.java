package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryFavouringRepositoryTest {
    MemoryFavouringRepository repository = new MemoryFavouringRepository();
    MemoryEssayRepository essayRepository = new MemoryEssayRepository();

    @AfterEach
    void afterEach() {
        repository.clear();
        essayRepository.clear();
    }

    @Test
    void addWhoFavour(){
        Essay essay = new Essay();
        essay.setWriter("seomoon");
        essayRepository.save(essay);

        Favouring favouring = new Favouring();
        favouring.setEssayId(essay.getId());
        favouring.setWhoFavour("seomoon");

        repository.addWhoFavour(favouring);
        List whoFavouring = repository.findWhoFavouring(essay);
        System.out.println("whoFavouring = " + whoFavouring);
        assertThat(whoFavouring).contains(favouring);
    }

    @Test
    void findWhoFavour() {
        Essay essay = new Essay();
        essay.setWriter("seomoon");
        essayRepository.save(essay);

        Favouring favouring1 = new Favouring();
        favouring1.setEssayId(essay.getId());
        favouring1.setWhoFavour("seostar");
        repository.addWhoFavour(favouring1);

        Favouring favouring2 = new Favouring();
        favouring2.setEssayId(essay.getId());
        favouring2.setWhoFavour("ubersky");
        repository.addWhoFavour(favouring2);

        List whoFavouring = repository.findWhoFavouring(essay);
        assertThat(whoFavouring.size()).isEqualTo(2);

    }

}