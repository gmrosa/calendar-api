package br.com.tblu.calendarapi.domain.entity;

import br.com.tblu.calendarapi.domain.type.RoleType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "person")
@EqualsAndHashCode(callSuper = true)
public class PersonEntity extends BaseEntity {

    private String name;
    private RoleType role;
}
