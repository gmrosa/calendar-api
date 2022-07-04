package br.com.tblu.calendarapi.domain.result;

import br.com.tblu.calendarapi.domain.entity.PersonEntity;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.Set;

@Data
@Builder
public class AvaliableSlotResult {

    private int start;
    private int end;
    private DayOfWeek dayOfWeek;
    private Set<PersonEntity> available;
}
