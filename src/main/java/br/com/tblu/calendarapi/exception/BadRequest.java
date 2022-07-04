package br.com.tblu.calendarapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequest extends ResponseStatusException {

    public BadRequest(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
