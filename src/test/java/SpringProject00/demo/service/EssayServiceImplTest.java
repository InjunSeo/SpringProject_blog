package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.repository.MemoryEssayRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EssayServiceImplTest {
    EssayServiceImpl essayService;
    MemoryEssayRepository essayRepository;

    @BeforeEach
    public void beforeEach() {
        essayRepository = new MemoryEssayRepository();
        essayService = new EssayServiceImpl(essayRepository);
    }
    @AfterEach
    public void afterEach() {
        essayRepository.clear();
    }

    @Test
    public void write() {
        Essay essay1 = new Essay("Seo", "IBE", "Inference");
        Essay write = essayService.write(essay1);
        Essay findEssay = essayRepository.findById(write.getId()).get();
        assertEquals(write.getId(), findEssay.getId());
    }

    @Test
    public void modify() {
        Essay essay1 = new Essay("Seo", "IBE", "Inference");
        Essay savedEssay = essayService.write(essay1);
        Long essayId = savedEssay.getId();
        //when
        Essay essay2 = new Essay("Seo", "IBE", "inference to the best Explanation");
        essayService.edit(essayId, essay2);
        Essay findEssay = essayService.findById(essayId).get();
        //Then
        assertThat(findEssay.getTitle()).isEqualTo(essay2.getTitle());
        assertThat(findEssay.getWriter()).isEqualTo(essay2.getWriter());
        assertThat(findEssay.getContent()).isEqualTo(essay2.getContent());
    }

}