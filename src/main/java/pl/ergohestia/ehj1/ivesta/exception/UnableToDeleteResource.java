package pl.ergohestia.ehj1.ivesta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnableToDeleteResource extends RuntimeException{
    public  UnableToDeleteResource(String message){super(message);}
}
