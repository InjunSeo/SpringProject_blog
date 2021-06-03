package SpringProject00.demo.controller;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.service.EssayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final EssayService essayService;

    @GetMapping("/")
    public String home(Model model) {
        List<Essay> essays = essayService.findAll();
        model.addAttribute("lists", essays);
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("user", "join us");
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(){
        return "redirect;/";
    }

 /*   @PostConstruct
    public void init() {
        essayService.write(new Essay("seomoon", "IBE", "Inference to the best explanation"));
        essayService.write(new Essay("uberSky", "Induction", "Problems of Induction"));
    }*/
}
