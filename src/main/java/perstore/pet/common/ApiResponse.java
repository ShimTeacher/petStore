package perstore.pet.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private int code;
    private HttpStatus status;
    private String message;

}
