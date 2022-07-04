package br.com.tblu.calendarapi.rest;

import br.com.tblu.calendarapi.domain.param.CreatePersonParam;
import br.com.tblu.calendarapi.domain.result.PageableContentResult;
import br.com.tblu.calendarapi.domain.result.PersonResult;
import br.com.tblu.calendarapi.domain.type.RoleType;
import br.com.tblu.calendarapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "person")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping
    @Transactional(readOnly = true)
    public PageableContentResult<PersonResult> list(@RequestParam Optional<RoleType> role,
                                                    @RequestParam int page,
                                                    @RequestParam int size) {
        return personService.list(role, page, size);
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody CreatePersonParam param) {
        personService.create(param);
    }
}
