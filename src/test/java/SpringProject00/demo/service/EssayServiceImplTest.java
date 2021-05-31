package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.repository.MemoryEssayRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Essay essay = new Essay();
        essay.setWriter("seomoon");
        essay.setTitle("on Denoting");
        Essay write = essayService.write(essay);
        Essay findEssay = essayRepository.findById(write.getId()).get();
        assertEquals(write.getId(), findEssay.getId());
    }

    @Test
    public void modify() {
        Essay essay = new Essay();
        essay.setWriter("seomoon");
        essay.setTitle("on Denoting");
        Essay write = essayService.write(essay);
        write.setContent("Russell");
        Essay modify = essayService.edit(write);
        assertEquals(write.getId(), modify.getId());

    }

}