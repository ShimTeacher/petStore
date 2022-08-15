package perstore.pet.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    //예외 발생시 메서드에 정의한 내용으로 로직 처리
    public ResponseEntity<ErrorResult> NotFountException(PetStoreException e){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(e.getCode());
        errorResult.setMessage(e.getMessage());
        errorResult.setStatus(e.getHttpStatus());

        return ResponseEntity.status(errorResult.getStatus()).body(errorResult);
    }
}
