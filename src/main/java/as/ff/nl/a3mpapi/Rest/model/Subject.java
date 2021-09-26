package as.ff.nl.a3mpapi.Rest.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
