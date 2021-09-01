package SpringProject00.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Favouring {
    @Id @GeneratedValue
    @Column(name = "FAVOURING_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ESSAY_ID")
    private Essay essay;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDateTime favourDate;

}
