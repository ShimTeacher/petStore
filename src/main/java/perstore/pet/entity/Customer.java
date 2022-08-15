package perstore.pet.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private int id;
    private String username;

    @Embedded
    private Address address;
}
