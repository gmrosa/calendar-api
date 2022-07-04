package br.com.tblu.calendarapi.exception;

public class SlotOverlapingException extends BadRequest {

    public SlotOverlapingException() {
        super("Slot overlap");
    }
}
