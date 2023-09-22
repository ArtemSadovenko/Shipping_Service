package project.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerService {
    @ExceptionHandler(value = IrregularData.class )
    public ResponseEntity<Object> handleServiceException(final IrregularData ex, final WebRequest request) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new MessageDto(ex.getMessage(), ex.getStatus()));
    }


}
