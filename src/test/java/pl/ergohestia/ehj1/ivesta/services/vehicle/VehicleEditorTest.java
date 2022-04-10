package pl.ergohestia.ehj1.ivesta.services.vehicle;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.ui.VehicleEditor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleEditorTest {


    UUID id;
    private VehicleDto testVehicle = new VehicleDto(id,"VOLVO", "Osobowy", "model", "typowy", "Serwis", "2020", 2000, 170, 120, 5, "Olej Napędowy",15,2000);

    @Test
    void shouldRetrieveChangedData(){
        //given
        VehicleEditor vehicleEditor = new VehicleEditor(testVehicle);
        String testBrand = "BMW";
        String testCategory = "B";
        String testModel = "X5";
        String testVehType = "Osobowy";
        String testProductionMethod = "Fabryczny";
        String testProductionYear = "2022";
        double testEngineCapacity = 2000;
        double testEnginePower = 150;
        double testHybridPower = 0;
        int testSeatsNumber = 5;
        String testFuelType = "ON";
        double testFuelConsumption = 10;
        double testWeightLimit = 5000;

        InputStream testIn = prepareInputStream(
                testBrand,
                testCategory,
                testModel,
                testVehType,
                testProductionMethod,
                testProductionYear,
                testEngineCapacity,
                testEnginePower,
                testHybridPower,
                testSeatsNumber,
                testFuelType,
                testFuelConsumption,
                testWeightLimit);

        //when
        VehicleDto result = vehicleEditor.editVehicle(testIn);

        //then
        assertThat(result.getBrand()).isEqualTo("BMW");

    }

    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append('\n');
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }

}