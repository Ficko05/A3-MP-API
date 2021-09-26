package as.ff.nl.a3mpapi.Rest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue
    long id;
    String name;
    String classroom;

    public Subject(){
        super();
    }

}
