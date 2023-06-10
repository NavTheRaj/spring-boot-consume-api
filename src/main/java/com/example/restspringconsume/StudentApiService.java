package com.example.restspringconsume;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@Service
public class StudentApiService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Autowired
    private Environment environment;


    public StudentApiService(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

//    public void fetchStudentFromExternalApi() throws URISyntaxException {
//        String urlString = "http://localhost:3000/api/v1/students";
//        URI uri = new URI(urlString);
//        webClient.get()
////                .uri(new URI(Objects.requireNonNull(environment.getProperty("student.list"))))
//                .uri(uri)
//                .retrieve()
//                .bodyToMono(String.class)
//                .subscribe(response->{
//                    try{
//                        List<StudentResponse> studentResponseList = objectMapper.
//                                readValue(response, new TypeReference<List<StudentResponse>>(){});
//                        System.out.println(studentResponseList.toString());
//                    }catch(Exception e){
//                        e.printStackTrace();
//                    }
//                });
//    }

    public Flux<StudentResponse> fetchStudentFromExternalApi(){
        String urlString = "http://localhost:3000/api/v1/students";

        return webClient.get()
                .uri(urlString)
                .retrieve().bodyToFlux(StudentResponse.class);
    }
}
