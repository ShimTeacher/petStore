package perstore.pet.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "pet")
    private List<Category> category;

    private String photoUrls;

    private Tag tags;

    @Enumerated(EnumType.STRING)
    private PetStatus status;


//    public static Pet of(String name, Category category, Tag tags, PetStatus status){
    public static Pet of(String name, List<Category> category, String tags, PetStatus status){
        return Pet.builder()
            .name(name)
//            .category(category)
//            .tags(tags)
            .status(status)
            .build();
    }
}
