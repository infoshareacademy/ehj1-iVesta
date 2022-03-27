package pl.ergohestia.ehj1.ivesta.services;

import pl.ergohestia.ehj1.ivesta.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleValidator {

    private Vehicle vehicle;
    private List<String> notValidParameters;

    public VehicleValidator() {
    }

    public VehicleValidator(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.notValidParameters = new ArrayList<>();
        validateConfigOfYearAndMethodProduction();
    }

    public boolean isVehicleValid() {
        validateSeats();
        validateVehicleCategory();
        validateWeightLLimit();
        validateYearProduction();
        validateVehicleType();

        return getNotValidParameters().size() == 0;
    }

    public void validateSeats() {
        if (!(vehicle.getNumberOfSeats() > 0)) {
            addParameterToList("Seats");
        }
    }

    public void validateYearProduction() {
        String year = vehicle.getProductionYear();
        if (!(year.length() == 4) || !Service.isNumeric(year)) {
            addParameterToList("Production year");
        }
    }

    public void validateVehicleCategory() {
        if (vehicle.getVehicleCategory() == null) {
            addParameterToList("Vehicle category");
        }
    }

    public void validateWeightLLimit(){
        if(!(vehicle.getWeightLimit() > 0)){
            addParameterToList("Max weight");
        }
    }

    public void validateVehicleType(){
        if(!(vehicle.getVehicleType() == null)){
            addParameterToList("Vehicle type");
        }
    }

    public List<String> getNotValidParameters() {
        return this.notValidParameters;
    }

    private void addParameterToList(String parameter) {
        this.notValidParameters.add(parameter);
    }

    private void validateConfigOfYearAndMethodProduction() {
        String productionMethod = vehicle.getProductionMethod();
        String productionYear = vehicle.getProductionYear();
        if (Service.isNumeric(productionMethod)) {
            vehicle.setProductionYear(productionMethod);
            vehicle.setProductionMethod(productionYear);
        }
    }


}
