package perstore.pet.controller;

import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.dto.PetCreateResponse;
import perstore.pet.dto.PetGetResponse;
import perstore.pet.service.PetService;

@RestController
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    @PutMapping("/pet/{id}")
    public ResponseEntity modifyPet(@PathVariable("id") int id, @RequestBody PetCreatRequest petCreatRequest){
        PetCreateResponse modifiedPet = petService.updatePetInfo(id, petCreatRequest);
        return ResponseEntity.ok().body(modifiedPet);
    }

    @PostMapping("/pet")
    public ResponseEntity creat(@RequestBody PetCreatRequest petCreatRequest){
        PetCreateResponse newPet = petService.creat(petCreatRequest);
        return ResponseEntity.ok().body(newPet);
    }

//    @GetMapping("/pet/findByStatus")
//    public ResponseEntity getStatus()
//    }
//    @GetMapping("/pet/findByTags)
//    public ResponseEntity getTags()

    @GetMapping("/pet/{id}")
    public ResponseEntity getOne(@PathVariable("id") int id){
        PetGetResponse getOne = petService.getOne(id);
        return ResponseEntity.ok().body(getOne);
    }

    @PostMapping("/pet/{id}")
    public ResponseEntity updatePet(@PathVariable("id") int id, @RequestBody PetCreatRequest petCreatRequest){
        PetCreateResponse updatedPet = petService.updatePet(id, petCreatRequest);
        return ResponseEntity.ok().body(updatedPet);
    }

    @DeleteMapping("/pet/{id}") //isDeleted는 스펙에 없는데 필요한가?
    public void deletePet(@PathVariable("id") int id){
        petService.deletePet(id);
    }

//    @PostMapping("/pet/{id}/uploadeImage")
//    public ResponseEntity uploadImage(@PathVariable("id") int id, @RequestBody PetCreatRequest petCreatRequest){
//
//    }

}
