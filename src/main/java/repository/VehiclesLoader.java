package repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class VehiclesLoader {
    private final ObjectMapper objectMapper = getDefaultObjectMapper();

    private ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        //config here
        return defaultObjectMapper;
    }


    public JsonNode parseToJsonNode(String input) throws IOException {
        return objectMapper.readTree(input);
    }
}
