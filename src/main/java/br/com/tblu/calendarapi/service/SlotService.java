package br.com.tblu.calendarapi.service;

import br.com.tblu.calendarapi.controller.PersonController;
import br.com.tblu.calendarapi.controller.SlotController;
import br.com.tblu.calendarapi.domain.entity.PersonEntity;
import br.com.tblu.calendarapi.domain.entity.SlotEntity;
import br.com.tblu.calendarapi.domain.mapper.SlotMapper;
import br.com.tblu.calendarapi.domain.param.CreateSlotParam;
import br.com.tblu.calendarapi.domain.result.PageableContentResult;
import br.com.tblu.calendarapi.domain.result.SlotResult;
import br.com.tblu.calendarapi.exception.PeriodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.Optional;

@Service
public class SlotService {

    private static final int DURATION = 1;
    @Autowired
    private SlotController slotController;
    @Autowired
    private PersonController personController;

    public PageableContentResult<SlotResult> list(String personName, Optional<DayOfWeek> dayOfWeek, int page, int size) {
        return SlotMapper.toPageable(slotController.findByPerson(personName, dayOfWeek, page, size));
    }

    public void create(CreateSlotParam param) {
        if (param.getEnd() <= param.getStart()) {
            throw new PeriodException();
        }
        PersonEntity person = personController.findByName(param.getPersonName());
        param.getDaysOfWeek().stream().forEach(dayOfWeek -> fillSlots(param, person, dayOfWeek));
    }

    private void fillSlots(CreateSlotParam param, PersonEntity person, DayOfWeek dayOfWeek) {
        int start = param.getStart();
        int end;
        do {
            end = start + DURATION;

            SlotEntity entity = SlotEntity.builder()
                    .person(person)
                    .start(start)
                    .end(end)
                    .dayOfWeek(dayOfWeek)
                    .build();

            slotController.save(entity);

            start = end;
        } while (start < param.getEnd());
    }
}
