package repository;

import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


class VehicleLoadingTest {

    private VehiclesLoader sut;

    @Test
    void shouldRetrieveJsonNodeFromStringInput() {
        try {
            //given
            sut = new VehiclesLoader();
            JsonNode result;
            String testString = "test json string input";
            String jsonSample = "{ \"title\": \"test json string input\" }";

            //when
            result = sut.parseToJsonNode(jsonSample);


            //then
            assertThat(result.get("title").asText()).isEqualTo(testString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}