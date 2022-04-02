package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.dao.VehicleDao;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.repository.VehiclesLoader;

import java.util.List;

public class VehicleService implements Service<VehicleDto>{

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private VehicleDao vehicleDao = new VehicleDao();
    private VehiclesLoader vehiclesLoader;
    private VehicleValidator vehicleValidator;
    private List<VehicleDto> vehicleDtoList;

    public VehicleService() {}

    public VehicleService(List<VehicleDto> vehicleDtoList){
        this.vehicleDtoList = vehicleDtoList;
    }

    public void LoadVehicle(){
        vehiclesLoader = new VehiclesLoader();
        vehicleDtoList = vehiclesLoader.getListOfVehicles();
        vehicleDtoList = getValidVehicles();
        for (VehicleDto vehicleDto:vehicleDtoList) {
            System.out.println(vehicleDto);
            vehicleDao.save(vehicleDto);
        }
    }


    private List<VehicleDto> getValidVehicles(){
        for (VehicleDto vehicleDto : vehicleDtoList) {
            vehicleValidator = new VehicleValidator(vehicleDto);
            if (!vehicleValidator.isVehicleValid()){
                LOG.info(vehicleDto + "has been removed");
                vehicleDtoList.remove(vehicleDto);
            }
        }
        return vehicleDtoList;
    }

    public List<VehicleDto> getVehiclesList(){
        return vehicleDtoList;
    }

    @Override
    public void printElements() {
        vehicleDtoList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    @Override
    public void addElement(VehicleDto vehicleDto) {
        vehicleDtoList.add(vehicleDto);
    }
}
