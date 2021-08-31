package SpringProject00.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String name;

    private LocalDateTime createDate;

    private char email;


}
