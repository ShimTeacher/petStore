package perstore.pet.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private int id;

    private String name;
}
