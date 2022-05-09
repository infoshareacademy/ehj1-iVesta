package pl.ergohestia.ehj1.ivesta.services;

import lombok.NoArgsConstructor;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class VehicleValidator {

    private VehicleDto vehicleDto;
    private List<String> notValidParameters;

    public VehicleValidator(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
        this.notValidParameters = new ArrayList<>();
    }

    public boolean isVehicleValid() {
        validateSeats();
        validateVehicleCategory();
        validateWeightLimit();

        return getNotValidParameters().isEmpty();
    }

    public void validateSeats() {
        if (vehicleDto.getNumberOfSeats() <= 0) {
            addParameterToNotValidParametersList("Seats");
        }
    }

    public void validateVehicleCategory() {
        if (vehicleDto.getLicense() == null) {
            addParameterToNotValidParametersList("Vehicle category");
        }
    }

    public void validateWeightLimit(){
        if(vehicleDto.getWeightLimit() <= 0){
            addParameterToNotValidParametersList("Max weight");
        }
    }

    public List<String> getNotValidParameters() {
        return this.notValidParameters;
    }

    private void addParameterToNotValidParametersList(String parameter) {
        this.notValidParameters.add(parameter);
    }
}
