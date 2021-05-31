package SpringProject00.demo.domain;

import java.util.Date;

public class Favouring {

    private long essayId;
    private String whoFavour;
    private Date favourDate;

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

    public Date getFavourDate() {
        return favourDate;
    }

    public void setFavourDate(Date fovourDate) {
        this.favourDate = fovourDate;
    }


}
