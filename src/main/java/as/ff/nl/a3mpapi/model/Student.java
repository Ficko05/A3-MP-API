package as.ff.nl.a3mpapi.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
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


