package lk.group1.auth.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFound extends RuntimeException{

    public DataNotFound(String message) {
        super(message);
    }




}
