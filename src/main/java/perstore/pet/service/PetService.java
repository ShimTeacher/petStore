package perstore.pet.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import perstore.pet.common.NotFoundException;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.dto.PetCreateResponse;
import perstore.pet.entity.Pet;
import perstore.pet.repository.PetRepository;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;


    public PetCreateResponse updatePetInfo(int id, PetCreatRequest petCreatRequest) {
        Pet newPet = petRepository.findById(id).orElseThrow(()-> new NotFoundException());
        newPet.setName(petCreatRequest.getName());
        newPet.setCategory(petCreatRequest.getCategory());
        newPet.setStatus(petCreatRequest.getStatus());
        newPet.setTags(petCreatRequest.getTags());
        petRepository.save(newPet);

        return PetCreateResponse.builder()
            .name(newPet.getName())
            .category(newPet.getCategory())
            .status(newPet.getStatus())
            .tags(newPet.getTags())
            .build();
    }

    public PetCreateResponse creat(PetCreatRequest petCreatRequest){
        Pet newPet = Pet
            .of(petCreatRequest.getName(), petCreatRequest.getCategory(), petCreatRequest.getTags(),
                petCreatRequest.getStatus());

        newPet.setName(petCreatRequest.getName());
        newPet.setCategory(petCreatRequest.getCategory());
        newPet.setTags(petCreatRequest.getTags());
        newPet.setStatus(petCreatRequest.getStatus());

        petRepository.save(newPet);

        return PetCreateResponse.builder()
            .id(newPet.getId())
            .name(newPet.getName())
            .category(newPet.getCategory())
            .tags(newPet.getTags())
            .status(newPet.getStatus())
            .build();
    }
}
