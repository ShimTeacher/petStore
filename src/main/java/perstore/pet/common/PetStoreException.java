package perstore.pet.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class PetStoreException extends RuntimeException{

    private final int code;
    private final String Message;
    private final HttpStatus httpStatus;

}
