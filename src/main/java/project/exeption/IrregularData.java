package project.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class IrregularData extends RuntimeException{
    private final HttpStatus status;

    public IrregularData(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage(){
        return super.getMessage();
    }
}
