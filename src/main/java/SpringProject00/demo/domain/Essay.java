package SpringProject00.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter @Setter
public class Essay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private Date createDate;
    private String content;
    private int favoured;

    public Essay() {
    }

    public Essay(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }


}
