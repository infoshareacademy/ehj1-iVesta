package pl.ergohestia.ehj1.ivesta.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtils {
    public static final String PERSISTENCE_UNIT_NAME = "ivestadb";
    public static final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();

    public static EntityManager getEntityManager() {
        return em;
    }
}
