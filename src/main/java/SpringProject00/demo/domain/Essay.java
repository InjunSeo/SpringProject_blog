package SpringProject00.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Essay {
    private Long id;
    private String writer;
    private String title;
    private Date createDate;
    private String content;
    private int favoured;

    public Essay(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
