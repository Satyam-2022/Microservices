package com.intuitive.student_service.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String age;
    private String gender;
    private Integer schoolId;


}
