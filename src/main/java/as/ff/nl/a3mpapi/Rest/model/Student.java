package as.ff.nl.a3mpapi.Rest.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity

public class Student {

    @Id
    @GeneratedValue
    long student_id;
    String name;
    String mail;

    @ManyToMany (mappedBy = "students")
    Set<Subject> subjects;

    public Student(){

        super();
    }


}


