package br.com.tblu.calendarapi.controller;

import br.com.tblu.calendarapi.domain.entity.PersonEntity;
import br.com.tblu.calendarapi.domain.type.RoleType;
import br.com.tblu.calendarapi.exception.PersonAlreadyExistsException;
import br.com.tblu.calendarapi.exception.PersonDoesNotExistException;
import br.com.tblu.calendarapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity findByName(String name) {
        return personRepository.findByName(name).orElseThrow(() -> new PersonDoesNotExistException(name));
    }

    public Page<PersonEntity> findAll(Optional<RoleType> role, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (role.isPresent()) {
            return personRepository.findAllByRole(role.get(), pageable);
        }
        return personRepository.findAll(pageable);
    }

    public void save(PersonEntity entity) {
        personRepository.findByName(entity.getName())
                .ifPresent(person -> {
                    throw new PersonAlreadyExistsException(person.getName());
                });
        personRepository.save(entity);
    }
}
