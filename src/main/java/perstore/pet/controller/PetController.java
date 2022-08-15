package perstore.pet.controller;

import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.dto.PetCreateResponse;
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

//    @GetMapping("/pet/status")
//    public ResponseEntity getStatus()
//    }


    //git Check





}
