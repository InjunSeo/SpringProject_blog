package SpringProject00.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Getter @Setter
public class Member {
    private String id;
    private String name;
    private Date createDate;
    private char email;


}
