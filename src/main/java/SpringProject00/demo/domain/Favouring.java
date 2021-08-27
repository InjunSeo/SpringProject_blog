package SpringProject00.demo.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Favouring {

    private long essayId;
    private String whoFavour;
    private LocalDateTime favourDate;

    public long getEssayId() {
        return essayId;
    }

    public void setEssayId(long essayId) {
        this.essayId = essayId;
    }

    public String getWhoFavour() {
        return whoFavour;
    }

    public void setWhoFavour(String whoFavour) {
        this.whoFavour = whoFavour;
    }

    public LocalDateTime getFavourDate() {
        return favourDate;
    }

    public void setFavourDate(LocalDateTime favourDate) {
        this.favourDate = favourDate;
    }
}
