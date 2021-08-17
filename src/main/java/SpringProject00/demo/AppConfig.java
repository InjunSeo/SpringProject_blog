package SpringProject00.demo;

import SpringProject00.demo.repository.*;
import SpringProject00.demo.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;

@Configuration
@ComponentScan
public class AppConfig {
    private final DataSource dataSource;
/*
    private final EntityManager em;
*/
    public AppConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    /* public AppConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    } */

//    @Bean
//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    @Bean
//    public EssayService essayService() {
//        return new EssayServiceImpl(new JdbcTemplateEssayRepository(dataSource));
//        /*return new EssayServiceImpl(new JpaEssayRepository(em));*/
//    }
//
//    @Bean
//    public FavourService favourService() {
//        return new FavourServiceImpl(new MemoryFavouringRepository());
//    }

}
