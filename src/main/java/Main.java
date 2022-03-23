import com.fasterxml.jackson.databind.JsonNode;
import repository.VehiclesLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        VehiclesLoader vehiclesInput = new VehiclesLoader();

        String json = "";

        try {
            JsonNode node = vehiclesInput.parseToJsonNode(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
