package perstore.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perstore.pet.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    //long 일때 동작하나?

}
