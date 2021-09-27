package as.ff.nl.a3mpapi.Rest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
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


