package com.intuitive.student_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School {

    private int id;
    private String schoolName;
    private String location;
    private String principleName;

}
