package br.com.tblu.calendarapi.service;

import br.com.tblu.calendarapi.controller.PersonController;
import br.com.tblu.calendarapi.domain.mapper.PersonMapper;
import br.com.tblu.calendarapi.domain.param.CreatePersonParam;
import br.com.tblu.calendarapi.domain.result.PageableContentResult;
import br.com.tblu.calendarapi.domain.result.PersonResult;
import br.com.tblu.calendarapi.domain.type.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonController personController;

    public PageableContentResult<PersonResult> list(Optional<RoleType> role, int page, int size) {
        return PersonMapper.toPageable(personController.findAll(role, page, size));
    }

    public void create(CreatePersonParam param) {
        personController.save(PersonMapper.toEntity(param));
    }
}
