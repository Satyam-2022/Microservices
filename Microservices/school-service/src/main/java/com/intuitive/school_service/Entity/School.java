package com.intuitive.school_service.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class School {

       private int id;
       private String schoolName;
       private String location;
       private String principleName;
}
