package pl.ergohestia.ehj1.ivesta.services.vehicle;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VehicleEditorTest {


    UUID id;
    private VehicleDto testVehicle = new VehicleDto(id,"VOLVO", "Osobowy", "model", "typowy", "Serwis", "2020", 2000, 170, 120, 5, "Olej Napędowy",15,2000);

    @Test
    void shouldRetrieveChangedData(){
        VehicleEditor vehicleEditor = new VehicleEditor(testVehicle);
        vehicleEditor.editVehicle();
    }
}