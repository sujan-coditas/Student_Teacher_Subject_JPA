package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;
    private String subName;
    @OneToOne(mappedBy = "subject")
    private Teacher teacher;

    public Subject() {
    }
}