package com.example.restspringconsume;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@JsonSerialize(using = StudentResponseSerializer.class)
@JsonDeserialize(using = StudentResponseDeserializer.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponse{
    private int id;
    private String fullName;
}
