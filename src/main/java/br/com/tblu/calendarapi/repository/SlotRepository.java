package br.com.tblu.calendarapi.repository;

import br.com.tblu.calendarapi.domain.entity.SlotEntity;
import br.com.tblu.calendarapi.domain.type.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends MongoRepository<SlotEntity, String> {

    Page<SlotEntity> findAllByPersonName(String personName, Pageable pageable);

    Page<SlotEntity> findAllByPersonNameAndDayOfWeek(String personName, DayOfWeek dayOfWeek, Pageable pageable);
    List<SlotEntity> findAllByPersonNameAndDayOfWeek(String personName, DayOfWeek dayOfWeek);

    List<SlotEntity> findAllByStartAndEndAndDayOfWeekAndPersonRole(int start, int end, DayOfWeek dayOfWeek, RoleType role);

    Optional<SlotEntity> findFirstByStartAndEndAndDayOfWeekAndPersonName(int start, int end, DayOfWeek dayOfWeek, String personName);
}
