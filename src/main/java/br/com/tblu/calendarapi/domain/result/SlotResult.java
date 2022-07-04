package br.com.tblu.calendarapi.domain.result;

import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;

@Data
@Builder
public class SlotResult {

    private PersonResult person;
    private int start;
    private int end;
    private DayOfWeek dayOfWeek;
}
