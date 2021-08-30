package org.grupocuatro.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
        return factory.createEntityManager();
    }

    public static void main(String [] args ){
        EntityManager manager = EntityManagerUtil.getEntityManager();
        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
    }
}
