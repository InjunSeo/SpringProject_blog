package SpringProject00.demo;

import SpringProject00.demo.repository.MemoryEssayRepository;
import SpringProject00.demo.repository.MemoryFavouringRepository;
import SpringProject00.demo.repository.MemoryMemberRepository;
import SpringProject00.demo.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Bean
    public EssayService essayService() {
        return new EssayServiceImpl(new MemoryEssayRepository());
    }

    @Bean
    public FavourService favourService() {
        return new FavourServiceImpl(new MemoryFavouringRepository());
    }

}
