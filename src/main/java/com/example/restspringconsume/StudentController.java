package com.example.restspringconsume;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Component
public class StudentController {

    private final StudentApiService studentApiService;

    public StudentController(StudentApiService studentApiService) {
        this.studentApiService = studentApiService;
    }

    @GetMapping("/students")
    public Flux<StudentResponse> fetchStudents(){
        return studentApiService.fetchStudentFromExternalApi();

    }

}
