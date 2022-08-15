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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import perstore.pet.dto.PetCreatRequest;
import perstore.pet.dto.PetCreateResponse;
import perstore.pet.dto.PetGetResponse;
import perstore.pet.entity.PetStatus;
import perstore.pet.service.PetService;

@RestController
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    /***
     * 이미 존재하는 펫 정보 업데이트
     */
    @PutMapping("/pet/{id}")
    public ResponseEntity modifyPet(@PathVariable("id") int id, @RequestBody PetCreatRequest petCreatRequest){
        PetCreateResponse modifiedPet = petService.updatePetInfo(id, petCreatRequest);
        return ResponseEntity.ok().body(modifiedPet);
    }

    /**
     * 새로운 펫 정보를 스토어에 업데이트
     * */
    @PostMapping("/pet")
    public ResponseEntity creat(@RequestBody PetCreatRequest petCreatRequest){
        PetCreateResponse newPet = petService.creat(petCreatRequest);
        return ResponseEntity.ok().body(newPet);
    }

    /**
     *펫의 Status로 조회
     */
    @GetMapping("/pet/findByStatus")
    public ResponseEntity getStatus(@RequestParam PetStatus status){
        PetGetResponse petStatus = petService.getStatus(status);
        return ResponseEntity.ok().body(petStatus);
    }

/**
 * 펫의 Tags로 조회
 * */
//    @GetMapping("/pet/findByTags)
//    public ResponseEntity getTags()


    /**
     * 펫의 Id로 조회
     * */
    @GetMapping("/pet/{id}")
    public ResponseEntity getOne(@PathVariable("id") int id){
        PetGetResponse getOne = petService.getOne(id);
        return ResponseEntity.ok().body(getOne);
    }

    /**
     * 폼데이터로 펫 업데이트
     * */
    @PostMapping("/pet/{id}")
    public ResponseEntity updatePet(@PathVariable("id") int id, @RequestBody PetCreatRequest petCreatRequest){
        PetCreateResponse updatedPet = petService.updatePet(id, petCreatRequest);
        return ResponseEntity.ok().body(updatedPet);
    }

    /**
     * 펫 삭제
     **/
//    @DeleteMapping("/pet/{id}") //isDeleted는 스펙에 없는데 필요한가?
//    public void deletePet(@PathVariable("id") int id){
//        petService.deletePet(id);
//    }


    /**
     * 펫 이미지 업데이트
     * */
//    @PostMapping("/pet/{id}/uploadeImage")
//    public ResponseEntity uploadImage(@PathVariable("id") int id, @RequestBody PetCreatRequest petCreatRequest){
//
//    }

}
