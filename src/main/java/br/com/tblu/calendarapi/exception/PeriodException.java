package br.com.tblu.calendarapi.exception;

public class PeriodException extends BadRequest {

    public PeriodException() {
        super("Start period should be greater than end period");
    }
}
