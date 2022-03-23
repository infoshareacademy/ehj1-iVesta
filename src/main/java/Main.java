import com.fasterxml.jackson.databind.JsonNode;
import repository.VehiclesLoading;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        VehiclesLoading vehiclesInput = new VehiclesLoading();

        String json = "";

        try {
            JsonNode node = vehiclesInput.parseToJsonNode(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
