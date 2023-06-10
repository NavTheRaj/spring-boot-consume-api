package com.example.restspringconsume;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class StudentResponseDeserializer extends JsonDeserializer<StudentResponse> {
    @Override
    public StudentResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int id = node.get("id").asInt();
        String fullName = node.get("full_name").asText();
        // Extract more fields if necessary
        return new StudentResponse(id, fullName);
    }
}

