package SpringProject00.demo.controller;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.service.EssayService;
import SpringProject00.demo.service.FavourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FavourController {
    private final FavourService favourService;
    private final EssayService essayService;

    public FavourController(FavourService favourService, EssayService essayService) {
        this.favourService = favourService;
        this.essayService = essayService;
    }

    @PostMapping(value = "/essays/addFavour")
    public String addFavour(Model model) {

        //해당 에세이 정보 반환받기
        // 그 에세이에 favour 추가하기
   /*     favourService.addWhoFavour();
        essayService.countFavour();*/
        List<Essay> essays = essayService.findAll();
        model.addAttribute("lists", essays);
        return "redirect;/";
    }
}
