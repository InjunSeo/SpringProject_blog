package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryEssayRepositoryTest {

    MemoryEssayRepository repository = new MemoryEssayRepository();

    @AfterEach
    public void AfterEach(){
        repository.clear();
    }

    @Test
    public void save(){
        Essay essay1 = new Essay("Seo", "IBE", "Inference");
        repository.save(essay1);
        Essay result = repository.findByName(essay1.getWriter()).get();
        assertThat(result).isEqualTo(essay1);
    }

    @Test
    public void modify() {
        Essay essay1 = new Essay("Seo", "IBE", "Infer to the best explanation");
        repository.save(essay1);
        Long essayId = essay1.getId();
        Essay essay2 = new Essay("seomoon", "Baysian", "P on prior beliefs");
        repository.modify(essayId, essay2);
        Essay result = repository.findById(essayId).get();
        assertThat(result.getWriter()).isEqualTo(essay2.getWriter());
    }

    @Test
    public void favour(){
        //Given
        Essay essay1 = new Essay("Seo", "IBE", "Infer to the best explanation");
        repository.save(essay1);
        Essay essay = repository.findByName(essay1.getWriter()).get();
        int favoured = essay.getFavoured();
        //When
        repository.countFavour(essay1);
        //Then
        Essay result = repository.findById(essay1.getId()).get();
        assertThat(result.getFavoured()).isEqualTo(favoured + 1);
    }


}