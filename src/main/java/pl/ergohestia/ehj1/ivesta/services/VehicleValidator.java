package pl.ergohestia.ehj1.ivesta.services;

import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleValidator {

    private VehicleDto vehicleDto;
    private List<String> notValidParameters;

    public VehicleValidator() {
    }

    public VehicleValidator(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
        this.notValidParameters = new ArrayList<>();
        validateConfigOfYearAndMethodProduction();
    }

    public boolean isVehicleValid() {
        validateSeats();
        validateVehicleCategory();
        validateWeightLimit();
        validateYearProduction();
        validateVehicleType();

        return getNotValidParameters().isEmpty();
    }

    public void validateSeats() {
        if (vehicleDto.getNumberOfSeats() <= 0) {
            addParameterToNotValidParametersList("Seats");
        }
    }

    public void validateYearProduction() {
        String year = vehicleDto.getProductionYear();
        if ((year.length() != 4) || !Service.isNumeric(year)) {
            addParameterToNotValidParametersList("Production year");
        }
    }

    public void validateVehicleCategory() {
        if (vehicleDto.getVehicleCategory() == null) {
            addParameterToNotValidParametersList("Vehicle category");
        }
    }

    public void validateWeightLimit(){
        if(vehicleDto.getWeightLimit() <= 0){
            addParameterToNotValidParametersList("Max weight");
        }
    }

    public void validateVehicleType(){
        if(vehicleDto.getVehicleType() == null){
            addParameterToNotValidParametersList("Vehicle type");
        }
    }

    public List<String> getNotValidParameters() {
        return this.notValidParameters;
    }

    private void addParameterToNotValidParametersList(String parameter) {
        this.notValidParameters.add(parameter);
    }

    private void validateConfigOfYearAndMethodProduction() {
        String productionMethod = vehicleDto.getProductionMethod();
        String productionYear = vehicleDto.getProductionYear();
        if (Service.isNumeric(productionMethod)) {
            vehicleDto.setProductionYear(productionMethod);
            vehicleDto.setProductionMethod(productionYear);
        }
    }


}
