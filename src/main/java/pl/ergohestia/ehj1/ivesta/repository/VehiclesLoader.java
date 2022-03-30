package pl.ergohestia.ehj1.ivesta.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VehiclesLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String ATTRIBUTES = "attributes";

    private final String path;

    public VehiclesLoader(Path path) {
        this.path = path.toString();
    }

    public List<VehicleDto> getListOfVehicles() {
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            Object object = jsonParser.parse(reader);
            JSONArray objectArray = (JSONArray) object;

            for (Object o : objectArray) {
                JSONObject vehicleObject = (JSONObject) o;
                JsonNode attributes = objectMapper.readTree(vehicleObject.toJSONString());
                JsonNode node = objectMapper.readTree(String.valueOf(attributes.get(ATTRIBUTES)));
                vehicleDtoList.add(fromJson(node, VehicleDto.class));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return vehicleDtoList;
    }

    public <A> A fromJson(JsonNode node, Class<A> classA) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classA);
    }
}