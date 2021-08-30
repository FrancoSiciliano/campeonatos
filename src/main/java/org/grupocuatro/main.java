package org.grupocuatro;

import org.grupocuatro.modelo.Club;
import org.grupocuatro.utiles.EntityManagerUtil;

import javax.persistence.EntityManager;

public class main {
    public static void main(String[] args) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(new Club(1,"Deportivo juguete", "Avenida siempreviva"));
        manager.getTransaction().commit();
        System.out.println("vamos los pibes");
    }
}
