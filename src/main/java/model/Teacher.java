package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String teacherName;
    private Date dateOfJoining;
    @OneToOne(cascade = CascadeType.ALL)
    private Subject subject;
    @OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)
    private List<Student> student;

    public Teacher() {
    }
}