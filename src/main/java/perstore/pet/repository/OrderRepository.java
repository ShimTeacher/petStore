package perstore.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import perstore.pet.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//    @Query("Select o from Order o where p.PetStatus ")
//    //쿼리로 enum 계산해서 뿌리기
}
