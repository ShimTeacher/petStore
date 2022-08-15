package perstore.pet.dto;


import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import perstore.pet.entity.Category;
import perstore.pet.entity.PetStatus;
import perstore.pet.entity.Tag;

@Data
@Builder
public class PetCreatRequest {

    @Id
    private int id;

    private String name;

    private Category category;

    //    private photoUrls photoUrls;

    private Tag tags;

    private PetStatus status;
}
