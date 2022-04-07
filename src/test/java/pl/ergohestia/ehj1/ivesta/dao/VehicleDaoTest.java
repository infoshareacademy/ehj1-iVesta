package pl.ergohestia.ehj1.ivesta.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.ui.InputScannerProvider;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VehicleDaoTest {

    private UUID testId;
    private VehicleDto testVehicle = new VehicleDto(testId,"VOLVO", "Osobowy", "model", "typowy", "Serwis", "2020", 2000, 170, 120, 5, "Olej Napędowy",15,2000);

    EntityManager em = HibernateUtils.getEntityManager();
    VehicleDao testDao;


  @AfterEach
    void cleanDb(){
        em.getTransaction().begin();
        em.createQuery("delete Vehicle").executeUpdate();
        em.getTransaction().commit();
    }


    @Test
    void shouldGetVehicleById() {
        //given

        testDao = new VehicleDao();

        //when
        testDao.save(testVehicle);
        Collection<VehicleDto> collection = testDao.findAll();
        testId = collection.iterator().next().getId();
        VehicleDto result = testDao.find(testId);

        //then
        assertThat(result.getId()).isEqualTo(testId);
    }

    @Test
    void shouldGetAllVehiclesFromDB() {
        //given
        testDao = new VehicleDao();

        //when
        testDao.save(testVehicle);
        Collection<VehicleDto> result = testDao.findAll();

        //then
        assertThat(result.size()).isEqualTo(1);

    }

    @Test
    void shouldSaveVehicle() {
        //given
        testDao = new VehicleDao();

        //when
        testDao.save(testVehicle);
        Collection<VehicleDto> result = testDao.findAll();

        //then
        assertThat(result).isNotEmpty();
    }

    @Test
    void shouldGetUpdatedVehicle() {
        //given
        testDao = new VehicleDao();
        testDao.save(testVehicle);
        testVehicle = testDao.findAll().iterator().next();
        testVehicle.setProductionYear("2022");
        testVehicle.setBrand("BMW");

        //when
        VehicleDto result = testDao.update(testVehicle);

        //then
        assertThat(result.getBrand()).isEqualTo("BMW");
        assertThat(result.getProductionYear()).isEqualTo("2022");

    }

    @Test
    void shouldDeleteVehicle() {
        //given
        testDao = new VehicleDao();
        testDao.save(testVehicle);
        VehicleDto testVehicle = testDao.findAll().iterator().next();

        //when
        testDao.delete(testVehicle);
        Collection<VehicleDto> result = testDao.findAll();

        //then
        assertThat(result).isEmpty();
    }
}