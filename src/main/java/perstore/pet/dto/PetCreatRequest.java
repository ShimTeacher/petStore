package perstore.pet.dto;


import java.util.List;
import lombok.Builder;
import lombok.Data;
import perstore.pet.entity.Category;
import perstore.pet.entity.PetStatus;
import perstore.pet.entity.Tag;

@Data
@Builder
public class PetCreatRequest {

    private int id;

    private String name;

    private List<Category> category;

    //    private photoUrls photoUrls;

    private String tags;

    private PetStatus status;
}
