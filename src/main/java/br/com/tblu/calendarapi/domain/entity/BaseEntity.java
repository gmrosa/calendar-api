package br.com.tblu.calendarapi.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseEntity implements Serializable {

    private String id;
}
