package com.intuitive.school_service.Service;

import com.intuitive.school_service.Entity.School;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class schoolService {

    private List<School>schools = new ArrayList<>();
    private int nextID =1;

    public School addSchool(School school){
        school.setId(nextID++);
        schools.add(school);
        return school;

    }

    @PostConstruct
    private void init(){
       addSchool(new School(nextID++,"KVL","Delhi","Hoke"));
        addSchool(new School(nextID+1,"DKVL","Chennai","Pukki"));
        addSchool(new School(nextID+1,"SVL","Mumbai","Naughty"));
        addSchool(new School(nextID+1,"DSCL","Punjab","Rowdy"));
        addSchool(new School(nextID+1,"SVL","Pune","DasRao"));
    }

    public List<School> getALLSchools() {
        return new ArrayList<>(schools);
    }

    public School getSchoolByID(int id){
        return schools.stream().filter(school -> school.getId()==id)
                .findFirst()
                .orElse(null);
    }

}
