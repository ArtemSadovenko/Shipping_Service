package project.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MessageDto {
    private HttpStatus status;
    private String message;

    public  MessageDto(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
