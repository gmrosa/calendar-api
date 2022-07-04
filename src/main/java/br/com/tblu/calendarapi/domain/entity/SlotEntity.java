package br.com.tblu.calendarapi.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;

@Data
@Builder
@Document(collection = "slot")
@EqualsAndHashCode(callSuper = true)
public class SlotEntity extends BaseEntity {

    private PersonEntity person;
    private int start;
    private int end;
    private DayOfWeek dayOfWeek;
}
