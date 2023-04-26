package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String studentName;
    private int studentAge  ;
    @ManyToOne
    private Teacher teacher;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "sid"),
            inverseJoinColumns = @JoinColumn(name = "cid"))
    private List<Course> course;

    public Student() {
    }
}
