package SpringProject00.demo.service;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.repository.EssayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class EssayServiceImpl implements EssayService {
    private final EssayRepository essayRepository;

    @Override
    public Essay write(Essay essay) {
        Essay save = essayRepository.save(essay);
        System.out.println("New essay = " + essay);
        return save;
    }

    @Override
    public Essay edit(Long essayId, Essay essay) {
        Essay editedEssay = essayRepository.modify(essayId, essay);
        return editedEssay;
    }

    @Override
    public Essay delete(Essay essay) {
        Essay delete = essayRepository.delete(essay);
        return delete;
    }

    @Override
    public Essay countFavour(Essay essay) {
        return essayRepository.countFavour(essay);
    }

    @Override
    public Optional<Essay> findById(long id) {
        Optional<Essay> essay = essayRepository.findById(id);
        return essay;
    }

    @Override
    public Optional<Essay> findByName(String writer) {
        return essayRepository.findByName(writer);
    }

    @Override
    public Optional<Essay> findByTitle(String title) {
        return essayRepository.findByTitle(title);
    }

    @Override
    public List<Essay> findAll() {
        return essayRepository.findAll();
    }
}
