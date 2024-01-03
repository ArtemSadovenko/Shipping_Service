package project.exeption;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class OrElseException extends RuntimeException implements Supplier<MessageDto> {
    private HttpStatus status;
    public OrElseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    public MessageDto get() {
        return new MessageDto(getMessage(), this.status);
    }
}
