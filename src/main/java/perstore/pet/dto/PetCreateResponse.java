package perstore.pet.dto;

import lombok.Builder;
import lombok.Data;
import perstore.pet.entity.Category;
import perstore.pet.entity.PetStatus;
import perstore.pet.entity.Tag;

@Data
@Builder
public class PetCreateResponse {

    private int id;

    private String name;

    private Category category;

    //    private photoUrls photoUrls;

    private Tag tags;

    private PetStatus status;
}
