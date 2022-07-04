package br.com.tblu.calendarapi.exception;

public class PersonDoesNotExistException extends BadRequest {

    public PersonDoesNotExistException(String personName) {
        super(String.format("Person %s does not exist", personName));
    }
}
