package perstore.pet.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tag {

    @Id
    private int id;

    private String name;

    @ManyToOne
    private Pet pet;

}
