package br.com.tblu.calendarapi.domain.result;

import br.com.tblu.calendarapi.domain.type.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResult {

    private String name;
    private RoleType role;
}
