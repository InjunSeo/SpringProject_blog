package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Member;

import javax.swing.text.html.Option;
import java.util.*;

public class MemoryEssayRepository implements EssayRepository {
    private static Map<Long, Essay> store = new HashMap();
    private static long sequence = 0L;
    
    @Override
    public Essay save(Essay essay) {
        essay.setId(++sequence);
        store.put(essay.getId(), essay);
        return essay;
    }

    @Override
    public Optional<Essay> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Essay> findByName(String writer) {
        return store.values().stream()
                .filter(essay -> essay.getWriter().equals(writer))
                .findAny();
    }

    @Override
    public Optional<Essay> findByTitle(String title) {
        return store.values().stream()
                .filter(essay -> essay.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Essay> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Essay modify(Essay essay) {
        store.replace(essay.getId(), essay);
        return essay;
    }

    @Override
    public Essay delete(Essay essay) {
        Essay remove = store.remove(essay.getId());
        return remove;
    }

    @Override
    public Essay countFavour(Essay essay) {
        int favoured = essay.getFavoured();
        essay.setFavoured(++favoured);
        store.replace(essay.getId(), essay);
        return essay;
    }

    public void clear(){
        store.clear();
    }

}
