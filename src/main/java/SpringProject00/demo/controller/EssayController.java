package SpringProject00.demo.controller;

import SpringProject00.demo.domain.Essay;
import SpringProject00.demo.domain.Member;
import SpringProject00.demo.service.EssayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Slf4j
@RequestMapping("/essays")
@Controller
@RequiredArgsConstructor
public class EssayController {

    private final EssayService essayService;

    @GetMapping("/{essayId}")
    public String essayDesc(@PathVariable("essayId") Long essayId, Model model) {
        Optional<Essay> essay = essayService.findById(essayId);
        model.addAttribute("desc", essay.get());
        log.info("[EssayController] essayDesc: essay={}", essay.get());
        return "/essays/essayDesc";
    }

    @GetMapping(value = "/new")
    public String essayForm() {
        return "/essays/essayForm";
    }

    //    @PostMapping(value = "/new")
    public String write(Member member, EssayForm form, Model model) {
        Essay essay = new Essay(member, form.getTitle(), form.getContent());
        essayService.write(essay);
        model.addAttribute("desc", essay);
        return "/essays/essayDesc";
    }

//    @PostMapping(value = "/new")
    public String addEssayV2(@ModelAttribute("desc") Essay essay) {
        essayService.write(essay);
        return "/essays/essayDesc";
    }
//    @PostMapping(value = "/new")
    public String addEssayV3(@ModelAttribute("desc") Essay essay) {
        essayService.write(essay);
        return "redirect:/essays/" + essay.getId();
    }
    @PostMapping(value = "/new")
    public String addEssayV4(@ModelAttribute("desc") Essay essay,
                             RedirectAttributes redirectAttributes) {
        Essay savedEssay = essayService.write(essay);
        redirectAttributes.addAttribute("essayId", savedEssay.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/essays/{essayId}";
    }

    @GetMapping("{essayId}/edit")
    public String edit(@PathVariable Long essayId, Model model) {
        Optional<Essay> essay = essayService.findById(essayId);
        model.addAttribute("desc", essay.get());
        log.info("[EssayController][edit] Edit essay={}", essay.get());
        return "essays/editForm";
    }

    @PostMapping("{essayId}/edit")
    public String edit(@PathVariable Long essayId,
                       @ModelAttribute("desc") Essay essay) {
        essayService.edit(essayId, essay);
        log.info("[EssayController][edit] edited essay={}", essay.getId());
        return "redirect:/essays/{essayId}";

    }

}
