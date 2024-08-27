package com.intuitive.student_service.Service;

import com.intuitive.student_service.Dto.School;
import com.intuitive.student_service.Dto.StudentResponse;
import com.intuitive.student_service.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class studentService {

    @Autowired
    private RestTemplate restTemplate;

    private List<Student>students=new ArrayList<>();
    private int nextId=1;

    public Student addStudent(Student student){
     student.setId(nextId++);
      students.add(student);
      return student;
    }

    @PostConstruct
    public void init(){
       addStudent(new Student(nextId++,"sam","14","male",2));
        addStudent(new Student(nextId+1,"sam","14","male",3));
        addStudent(new Student(nextId+1,"sam","14","male",4));
        addStudent(new Student(nextId+1,"sam","14","male",5));
        addStudent(new Student(nextId+1,"sam","14","male",6));
    }

    public List<Student> getAllstudents(){
        return new ArrayList<>(students);
    }

    public Student getStudentByID(int id){
        return students.stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public ResponseEntity<?> fetchStudentById(int id){
        Optional<Student>student= Optional.ofNullable(getStudentByID(id));
        if(student.isPresent()){
            School school = restTemplate.getForObject("http://SCHOOL-SERVICE/school/"+student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Not Found Student",HttpStatus.NOT_FOUND);
        }
    }

}
