package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.dao.VehicleDao;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.repository.VehiclesLoader;

import java.util.Collection;
import java.util.List;

public class VehicleService implements Service<VehicleDto> {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private final VehicleDao vehicleDao = new VehicleDao();
    private List<VehicleDto> vehicleDtoList;

    public VehicleService() {
    }

    public VehicleService(List<VehicleDto> vehicleDtoList) {
        this.vehicleDtoList = vehicleDtoList;
    }

    public void LoadVehicle() {
        VehiclesLoader vehiclesLoader = new VehiclesLoader();
        vehicleDtoList = vehiclesLoader.getListOfVehicles();
        List<VehicleDto> validList = saveValidVehicles();
        for (VehicleDto vehicleDto : validList) {
            SYSOUT.info("Valid: " + vehicleDto);
            vehicleDao.save(vehicleDto);
        }
    }

    public Collection<VehicleDto> getVehicleDtoList() {
        return vehicleDao.findAll();
    }


    private List<VehicleDto> saveValidVehicles() {
        for (VehicleDto vehicleDto : vehicleDtoList) {
            VehicleValidator vehicleValidator = new VehicleValidator(vehicleDto);
            if (vehicleValidator.isVehicleValid()) {
                SYSOUT.info(vehicleDto + " is valid");
            } else {
                SYSOUT.warn(vehicleDto + " has been removed");
                vehicleDtoList.remove(vehicleDto);
            }
        }
        return vehicleDtoList;
    }

    public List<VehicleDto> getVehiclesList() {
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
