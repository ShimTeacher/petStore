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
import perstore.pet.dto.PetGetResponse;
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

//    @Test
//    @DisplayName("펫을 스토어에 추가")
//    void creatPet() {
//        PetService petService = new PetService(petRepository);
//
//        //given
//        PetCreatRequest mod1 = PetCreatRequest.builder()
//            .id(1)
//            .name("pet1")
//            .category("category1")
//            .tags("tag1")
//            .status(PetStatus.PENDING)
//            .build();
//
//
//        //when
//
//        petService.creat(mod1);
//
//        when(petRepository.findAll()).thenReturn(List.of(pet));
//
//        //then
//        assertEquals("pet1",petService.getOne(1).getName());
//    }

    @Test
    @DisplayName("펫 하나 조회")
    void getOne(){
        PetService petService = new PetService(petRepository);

        //given
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("pet1");
        pet.setStatus(PetStatus.AVAILABLE);
//        pet.setTags(pet.getTags());
//        pet.setCategory(pet.getCategory());

        //when
        when(petRepository.findById(1)).thenReturn(Optional.of(pet));

        PetGetResponse newPet = petService.getOne(1);
//        petService.getStatus(PetStatus.AVAILABLE);

        //then
        assertEquals("pet1", newPet.getName());
        assertEquals(PetStatus.AVAILABLE, newPet.getStatus());
    }

    @Test
    @DisplayName("펫 status 조회")
    void 펫_단건_조회(){
        PetService petService = new PetService(petRepository);

        //given
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("pet1");
        pet1.setStatus(PetStatus.AVAILABLE);


        //when
//        when(petRepository.findById(1)).thenReturn(Optional.of(pet));
        when(petRepository.findPetStatus(PetStatus.AVAILABLE)).thenReturn(List.of(pet1));

        List<PetGetResponse> newPetList = petService.getStatus(PetStatus.AVAILABLE);
        PetGetResponse petGetResponse = newPetList.get(0);

        //then
        assertEquals(1, newPetList.size());
        assertEquals(PetStatus.AVAILABLE, petGetResponse.getStatus());
    }

    @Test
    @DisplayName("펫 status 다건 조회")
    void 펫_status_다건_조회(){
        PetService petService = new PetService(petRepository);

        //given
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("pet1");
        pet1.setStatus(PetStatus.AVAILABLE);

        Pet pet2 = new Pet();
        pet2.setId(1);
        pet2.setName("pet2");
        pet2.setStatus(PetStatus.AVAILABLE);

        //when
//        when(petRepository.findById(1)).thenReturn(Optional.of(pet));
        when(petRepository.findPetStatus(PetStatus.AVAILABLE)).thenReturn(List.of(pet1, pet2));

        List<PetGetResponse> newPetList = petService.getStatus(PetStatus.AVAILABLE);

        //then
        assertEquals(2, newPetList.size());
    }
}
