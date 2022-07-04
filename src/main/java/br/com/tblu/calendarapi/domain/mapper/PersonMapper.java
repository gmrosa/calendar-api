package br.com.tblu.calendarapi.domain.mapper;

import br.com.tblu.calendarapi.domain.entity.PersonEntity;
import br.com.tblu.calendarapi.domain.param.CreatePersonParam;
import br.com.tblu.calendarapi.domain.result.PageableContentResult;
import br.com.tblu.calendarapi.domain.result.PersonResult;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class PersonMapper {

    public PersonEntity toEntity(CreatePersonParam param) {
        return PersonEntity.builder()
                .name(param.getName())
                .role(param.getRole())
                .build();
    }

    public PageableContentResult<PersonResult> toPageable(Page<PersonEntity> page) {
        return PageableContentResult.<PersonResult>builder()
                .data(toResultList(page.getContent()))
                .isLast(page.isLast())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();
    }

    public PersonResult toResult(PersonEntity person) {
        return PersonResult.builder()
                .name(person.getName())
                .role(person.getRole())
                .build();
    }

    private List<PersonResult> toResultList(List<PersonEntity> content) {
        return content.stream()
                .map(toResult())
                .collect(Collectors.toList());
    }

    private Function<PersonEntity, PersonResult> toResult() {
        return person -> toResult(person);
    }
}
