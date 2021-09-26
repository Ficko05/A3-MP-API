package as.ff.nl.a3mpapi.Rest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@ToString
@Entity

public class Student {

    @Id
    @GeneratedValue
    long id;
    String name;
    String mail;

    public Student(){

        super();
    }


}


