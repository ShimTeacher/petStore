package perstore.pet.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import perstore.pet.common.NotFoundException;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.dto.PetCreateResponse;
import perstore.pet.dto.PetGetResponse;
import perstore.pet.entity.Pet;
import perstore.pet.entity.PetStatus;
import perstore.pet.repository.PetRepository;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;


    public PetCreateResponse updatePetInfo(int id, PetCreatRequest petCreatRequest) {
        Pet newPet = petRepository.findById(id).orElseThrow(()-> new NotFoundException());
        newPet.setName(petCreatRequest.getName());
//        newPet.setCategory(petCreatRequest.getCategory());
        newPet.setStatus(petCreatRequest.getStatus());
//        newPet.setTags(petCreatRequest.getTags());
        petRepository.save(newPet);

        return PetCreateResponse.builder()
            .id(newPet.getId())
            .name(newPet.getName())
//            .category(newPet.getCategory())
            .status(newPet.getStatus())
//            .tags(newPet.getTags())
            .build();
    }

    public PetCreateResponse creat(PetCreatRequest petCreatRequest){
        Pet newPet = Pet
//            .of(petCreatRequest.getName(), petCreatRequest.getCategory(), petCreatRequest.getTags(),
//                petCreatRequest.getStatus());
        .of(petCreatRequest.getName(), petCreatRequest.getCategory(), petCreatRequest.getTags(),
            petCreatRequest.getStatus());


        newPet.setName(petCreatRequest.getName());
//        newPet.setCategory(petCreatRequest.getCategory());
//        newPet.setTags(petCreatRequest.getTags());
        newPet.setStatus(petCreatRequest.getStatus());

        petRepository.save(newPet);

        return PetCreateResponse.builder()
            .id(newPet.getId())
            .name(newPet.getName())
//            .category(newPet.getCategory())
//            .tags(newPet.getTags())
            .status(newPet.getStatus())
            .build();
    }

    public PetGetResponse getOne(int id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return PetGetResponse.builder()
            .id(pet.getId())
            .name(pet.getName())
//            .category(pet.getCategory())
//            .tags(pet.getTags())
            .status(pet.getStatus())
            .build();
    }

    public PetCreateResponse updatePet(int id, PetCreatRequest petCreatRequest) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new NotFoundException());

        pet.setName(petCreatRequest.getName());
        pet.setStatus(petCreatRequest.getStatus());

        petRepository.save(pet);

        return PetCreateResponse.builder()
            .id(pet.getId())
            .name(pet.getName())
            .status(pet.getStatus())
            .build();
    }

//    public void deletePet(int id) {
//        Pet pet = petRepository.findById(id).orElseThrow(() -> new NotFoundException());
//        pet.setIs_deleted(1);
//
//        petRepository.save(pet);
//    }

    public List<PetGetResponse> getStatus(PetStatus status) {
        List<Pet> pet = petRepository.findPetStatus(status);
        return pet.stream().map(item -> PetGetResponse.builder()
            .id(item.getId())
            .name(item.getName())
            .status(item.getStatus())
            .category(item.getCategory())
            .tags(item.getTags())
            .build()
        ).collect(Collectors.toList());
    }
}
