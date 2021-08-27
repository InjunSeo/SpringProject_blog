package SpringProject00.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter
public class Member {
    @Id
    private String id;
    private String name;
    private LocalDateTime createDate;
    private char email;


}
