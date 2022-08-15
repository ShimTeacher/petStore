package perstore.pet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.entity.Pet;
import perstore.pet.entity.PetStatus;
import perstore.pet.entity.Tag;
import perstore.pet.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @Mock
    PetRepository petRepository;

    @Test
    @DisplayName("펫 목록 업데이트")
    void modifyPet(){
        PetService petService = new PetService(petRepository);

        //given
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("pet1");
        pet.setStatus(PetStatus.AVAILABLE);
//        pet.setTags(pet.getTags());
//        pet.setCategory(pet.getCategory());

        //when
        PetCreatRequest mod1 = PetCreatRequest.builder()
            .id(2)
            .name("pet2")
            .status(PetStatus.PENDING)
            .build();

        petService.updatePetInfo(1, mod1);

        //then
        assertEquals(2,pet.getId());
        assertEquals("pet2",pet.getName());
    }
}