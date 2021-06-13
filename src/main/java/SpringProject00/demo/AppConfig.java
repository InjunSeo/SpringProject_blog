package SpringProject00.demo;

import SpringProject00.demo.repository.JdbcTemplateEssayRepository;
import SpringProject00.demo.repository.MemoryEssayRepository;
import SpringProject00.demo.repository.MemoryFavouringRepository;
import SpringProject00.demo.repository.MemoryMemberRepository;
import SpringProject00.demo.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    private final DataSource dataSource;

    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Bean
    public EssayService essayService() {
        return new EssayServiceImpl(new JdbcTemplateEssayRepository(dataSource));
    }

    @Bean
    public FavourService favourService() {
        return new FavourServiceImpl(new MemoryFavouringRepository());
    }

}
