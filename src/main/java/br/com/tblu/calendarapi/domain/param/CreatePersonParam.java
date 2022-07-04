package br.com.tblu.calendarapi.domain.param;

import br.com.tblu.calendarapi.domain.type.RoleType;
import lombok.Data;

@Data
public class CreatePersonParam {

    private String name;
    private RoleType role;
}
