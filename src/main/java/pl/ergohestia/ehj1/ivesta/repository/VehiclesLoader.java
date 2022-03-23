package pl.ergohestia.ehj1.ivesta.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class VehiclesLoader {

    private final VehicleService vehicleService = new VehicleService();
    private final JSONParser jsonParser = new JSONParser();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String ATTRIBUTES = "attributes";

    private Vehicle vehicle;
    private final String path;

    public VehiclesLoader(Path path) {
        this.path = path.toString();
    }

    public List<Vehicle> getListOfVehicles() {
        JSONParser jsonParser = new JSONParser();
        Object object;
        try (FileReader reader = new FileReader(path)) {
            object = jsonParser.parse(reader);
            JSONArray objectArray = (JSONArray) object;

            for (Object o : objectArray) {
                JSONObject vehicleObject = (JSONObject) o;
                JsonNode attributes = objectMapper.readTree(vehicleObject.toJSONString());
                JsonNode node = objectMapper.readTree(String.valueOf(attributes.get(ATTRIBUTES)));
                vehicleService.addVehicleToList(fromJson(node, Vehicle.class));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return vehicleService.getVehiclesList();
    }

    public <A> A fromJson(JsonNode node, Class<A> classA) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classA);
    }
}