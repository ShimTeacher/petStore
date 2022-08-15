package perstore.pet.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String category;

    private String photoUrls;

    private String tags;

    @Enumerated(EnumType.STRING)
    private PetStatus status;

    private int is_deleted;

//    public static Pet of(String name, Category category, Tag tags, PetStatus status){
    public static Pet of(String name, String category, String tags, PetStatus status){
        return Pet.builder()
            .name(name)
//            .category(category)
//            .tags(tags)
            .status(status)
            .build();
    }
}
