package br.com.tblu.calendarapi.domain.param;

import lombok.Data;

import java.time.DayOfWeek;
import java.util.Set;

@Data
public class CreateSlotParam {

    private String personName;
    private int start;
    private int end;
    private Set<DayOfWeek> daysOfWeek;
}
