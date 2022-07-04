package br.com.tblu.calendarapi.controller;

import br.com.tblu.calendarapi.domain.entity.SlotEntity;
import br.com.tblu.calendarapi.domain.type.RoleType;
import br.com.tblu.calendarapi.exception.SlotOverlapingException;
import br.com.tblu.calendarapi.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Controller
public class SlotController {

    @Autowired
    private SlotRepository slotRepository;

    public Page<SlotEntity> findByPerson(String personName, Optional<DayOfWeek> dayOfWeek, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (dayOfWeek.isPresent()) {
            return slotRepository.findAllByPersonNameAndDayOfWeek(personName, dayOfWeek.get(), pageable);
        }
        return slotRepository.findAllByPersonName(personName, pageable);
    }

    public List<SlotEntity> findAllByPersonNameAndDayOfWeek(String personName, DayOfWeek dayOfWeek) {
        return slotRepository.findAllByPersonNameAndDayOfWeek(personName, dayOfWeek);
    }

    public List<SlotEntity> findAllByStartAndEndAndDayOfWeekAndPersonRole(int start, int end, DayOfWeek dayOfWeek, RoleType role) {
        return slotRepository.findAllByStartAndEndAndDayOfWeekAndPersonRole(start, end, dayOfWeek, role);
    }

    public void save(SlotEntity entity) {
        slotRepository.findFirstByStartAndEndAndDayOfWeekAndPersonName(
                        entity.getStart(),
                        entity.getEnd(),
                        entity.getDayOfWeek(),
                        entity.getPerson().getName())
                .ifPresent(person -> {
                    throw new SlotOverlapingException();
                });

        slotRepository.save(entity);
    }
}
