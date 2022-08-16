package perstore.pet.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class PetStoreException extends RuntimeException{

    private final int code;
    private final String Message;
    private final HttpStatus httpStatus;

}
