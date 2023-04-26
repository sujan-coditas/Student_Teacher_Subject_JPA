package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String CourseName;
    private Date StartingDate;
    private Date EndingDate;

    @ManyToMany(mappedBy="course",cascade = CascadeType.ALL)
    private List<Student> student;

}
