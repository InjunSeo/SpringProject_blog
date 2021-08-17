package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Favouring;
import SpringProject00.demo.domain.Member;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryFavouringRepository implements FavouringRepository{
    private static Map<Long, ArrayList> store = new HashMap();
    private ArrayList<Favouring> listOfWhoFavour;
    // 01, [

    @Override
    public Favouring addWhoFavour(Favouring favouring) {
        long essayId = favouring.getEssayId(); // favour하고자 하는 에세이의 id 값
        if(store.containsKey(essayId)) {
            ArrayList arrayList = store.get(essayId);
            arrayList.add(favouring);
            store.replace(essayId, arrayList);
        }else{
            listOfWhoFavour = new ArrayList<>();
            listOfWhoFavour.add(favouring);
            store.put(essayId, listOfWhoFavour);
        }
        return favouring;
    }

    @Override
    public List findWhoFavouring(Essay essay) {
        Long essayId = essay.getId();
        ArrayList peopleWhoFavour = store.get(essayId);
        return peopleWhoFavour;
    }

    @Override
    public List<Essay> findAll() {
        return null;
    }

    public void clear(){
        store.clear();
    }
}
