package br.com.tblu.calendarapi.domain.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageableContentResult<E> {

    List<E> data;
    boolean isLast;
    int totalPages;
    long totalElements;
}
