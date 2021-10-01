package org.grupocuatro.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("persistencia");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
