package br.com.tblu.calendarapi.repository;

import br.com.tblu.calendarapi.domain.entity.PersonEntity;
import br.com.tblu.calendarapi.domain.type.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<PersonEntity, String> {

    Optional<PersonEntity> findByName(String name);
    Page<PersonEntity> findAllByRole(RoleType role, Pageable pageable);
}
