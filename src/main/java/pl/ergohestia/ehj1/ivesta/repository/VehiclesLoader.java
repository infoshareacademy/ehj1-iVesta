package pl.ergohestia.ehj1.ivesta.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.configs.DefaultVehiclePath;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiclesLoader {

    private static final Logger log = LoggerFactory.getLogger(VehiclesLoader.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String ATTRIBUTES = "attributes";

    Scanner scanner = new Scanner(System.in);
    private final Path path;

    public VehiclesLoader(){this.path = getPath();}

    public VehiclesLoader(Path path) {
        this.path = path;
    }

    public List<VehicleDto> getListOfVehicles() {
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(String.valueOf(path))) {
            Object object = jsonParser.parse(reader);
            JSONArray objectArray = (JSONArray) object;

            for (Object o : objectArray) {
                JSONObject vehicleObject = (JSONObject) o;
                JsonNode attributes = objectMapper.readTree(vehicleObject.toJSONString());
                JsonNode node = objectMapper.readTree(String.valueOf(attributes.get(ATTRIBUTES)));
                vehicleDtoList.add(fromJson(node, VehicleDto.class));
            }

        } catch (IOException | ParseException e) {
            log.warn("Failed while loading file",e);
        }
        return vehicleDtoList;
    }

    public <A> A fromJson(JsonNode node, Class<A> classA) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classA);
    }

    private Path getPath() {
        try {
            SYSOUT.info("Czy pliki dotyczące pojazdu mają byc wczytane z domyślnej ścieżki? \n T\\N");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("t")) {
                DefaultVehiclePath defaultPath = new DefaultVehiclePath();
                return defaultPath.vehiclePath;
            } else if (answer.equalsIgnoreCase("n")) {
                SYSOUT.info("Proszę o podanie pełnej ścieżki z lokalizacją pliku: ");
                answer = scanner.nextLine();
                DefaultVehiclePath defaultPath = new DefaultVehiclePath(answer);
                return defaultPath.vehiclePath;
            }
        } catch (Exception e) {
            SYSOUT.warn("Brak pliku w podanym katalogu! Sprawdź ponownie ścieżkę dostępu.");
        }
        return getPath();
    }
}