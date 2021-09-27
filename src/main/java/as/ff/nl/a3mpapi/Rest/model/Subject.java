package as.ff.nl.a3mpapi.Rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue
    long subject_id;
    String name;
    String classroom;

    @ManyToMany
    @JoinTable(
            name = "subject_students",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    Set<Student> students;

    public Subject(){
        super();
    }

}
