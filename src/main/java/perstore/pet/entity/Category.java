package perstore.pet.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "cagetory_id")
    private int id;

    private String name;

    @ManyToOne
    private Pet pet;
}
