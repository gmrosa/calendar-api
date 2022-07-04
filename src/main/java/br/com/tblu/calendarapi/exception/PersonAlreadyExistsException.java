package br.com.tblu.calendarapi.exception;

public class PersonAlreadyExistsException extends BadRequest {

    public PersonAlreadyExistsException(String personName) {
        super(String.format("Person %s already exists", personName));
    }
}
