package SpringProject00.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor @NoArgsConstructor
public class Essay {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESSAY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    @NonNull
    private Member member;

    @NonNull
    private String title;

    @NonNull
    private String content;

    private Date createDate;

    @OneToMany(mappedBy = "essay")
    private List<Favouring> favours = new ArrayList<>();

    @ManyToMany(mappedBy = "essays")
    private List<Category> categories = new ArrayList<>();
}
