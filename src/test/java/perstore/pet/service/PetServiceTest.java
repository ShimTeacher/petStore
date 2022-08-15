package perstore.pet.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import perstore.pet.common.NotFoundException;
import perstore.pet.common.PetStoreException;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.dto.PetCreateResponse;
import perstore.pet.entity.Pet;
import perstore.pet.entity.PetStatus;
import perstore.pet.entity.Tag;
import perstore.pet.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @Mock
    PetRepository petRepository;

    @Test
    @DisplayName("NotFoundException Test")
    void nouFound(){
        PetService petService = new PetService(petRepository);
        PetCreatRequest mod1 = PetCreatRequest.builder()
            .id(2)
            .name("pet2")
            .status(PetStatus.PENDING)
            .build();

        assertThrows(NotFoundException.class,() -> {petService.updatePetInfo(1,mod1);});
    }



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
//        when(addressRepository.findAll()).thenReturn(List.of(address1, address2, address3, address4));
        when(petRepository.findById(1)).thenReturn(Optional.of(pet));

        PetCreatRequest mod1 = PetCreatRequest.builder()
            .name("pet2")
            .status(PetStatus.PENDING)
            .build();

        petService.updatePetInfo(1, mod1);

        //then
        assertEquals(PetStatus.PENDING,pet.getStatus());
        assertEquals("pet2",pet.getName());
    }

    @Test
    @DisplayName("펫을 스토어에 추가")
    void creat() {
        PetService petService = new PetService(petRepository);

        //given
        PetCreatRequest mod1 = PetCreatRequest.builder()
            .id(1)
            .name("pet1")
            .category("category1")
            .tags("tag1")
            .status(PetStatus.PENDING)
            .build();

        //when
        petService.creat(mod1);


        when(petRepository.findAll()).thenReturn(mod1);

        //then
        assertEquals("dog1",petService.getOne(1).getName());
        assertEquals("Category2",petService.getOne(2).getCategory());
        assertEquals("tag3",petService.getOne(3).getTags());
        assertEquals(PetStatus.AVAILABLE,petService.getOne(3).getStatus());
    }
}