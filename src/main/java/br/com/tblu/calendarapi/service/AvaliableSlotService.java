package br.com.tblu.calendarapi.service;

import br.com.tblu.calendarapi.controller.SlotController;
import br.com.tblu.calendarapi.domain.entity.PersonEntity;
import br.com.tblu.calendarapi.domain.entity.SlotEntity;
import br.com.tblu.calendarapi.domain.result.AvaliableSlotResult;
import br.com.tblu.calendarapi.domain.type.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AvaliableSlotService {

    @Autowired
    private SlotController slotController;

    public List<AvaliableSlotResult> list(String personName, DayOfWeek dayOfWeek) {
        return slotController.findAllByPersonNameAndDayOfWeek(personName, dayOfWeek)
                .stream()
                .map(mapSlot())
                .collect(Collectors.toList())
                .stream()
                .filter(avaliableSlotResult -> !avaliableSlotResult.getAvailable().isEmpty())
                .collect(Collectors.toList());
    }

    private Function<SlotEntity, AvaliableSlotResult> mapSlot() {
        return slot -> AvaliableSlotResult.builder()
                .start(slot.getStart())
                .end(slot.getEnd())
                .dayOfWeek(slot.getDayOfWeek())
                .available(getAvaliables(slot))
                .build();
    }

    private Set<PersonEntity> getAvaliables(SlotEntity slot) {
        return slotController.findAllByStartAndEndAndDayOfWeekAndPersonRole(
                        slot.getStart(),
                        slot.getEnd(),
                        slot.getDayOfWeek(),
                        getOpositeRole(slot.getPerson().getRole())).stream()
                .map(SlotEntity::getPerson)
                .collect(Collectors.toSet());
    }

    private RoleType getOpositeRole(RoleType role) {
        if (RoleType.CANDIDATE.equals(role)) {
            return RoleType.INTERVIEWER;
        }
        return RoleType.CANDIDATE;
    }
}
