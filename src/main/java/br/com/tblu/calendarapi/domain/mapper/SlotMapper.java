package br.com.tblu.calendarapi.domain.mapper;

import br.com.tblu.calendarapi.domain.entity.SlotEntity;
import br.com.tblu.calendarapi.domain.result.PageableContentResult;
import br.com.tblu.calendarapi.domain.result.SlotResult;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class SlotMapper {

    public PageableContentResult<SlotResult> toPageable(Page<SlotEntity> page) {
        return PageableContentResult.<SlotResult>builder()
                .data(toResultList(page.getContent()))
                .isLast(page.isLast())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();
    }

    private List<SlotResult> toResultList(List<SlotEntity> content) {
        return content.stream()
                .map(toResult())
                .collect(Collectors.toList());
    }

    private Function<SlotEntity, SlotResult> toResult() {
        return slot -> SlotResult.builder()
                .person(PersonMapper.toResult(slot.getPerson()))
                .start(slot.getStart())
                .end(slot.getEnd())
                .dayOfWeek(slot.getDayOfWeek())
                .build();
    }
}
