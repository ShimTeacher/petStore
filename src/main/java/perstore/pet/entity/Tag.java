package perstore.pet.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    private int id;

    private String name;

}
