package com.example.restspringconsume;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class StudentResponseSerializer extends JsonSerializer<StudentResponse> {
    @Override
    public void serialize(StudentResponse studentResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", studentResponse.getId());
        jsonGenerator.writeStringField("full_name", studentResponse.getFullName());
        // Add more fields if necessary
        jsonGenerator.writeEndObject();
    }
}

