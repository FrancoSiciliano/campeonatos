package org.grupocuatro.dao;

import org.grupocuatro.utiles.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;

public abstract class AbstractDao<T> implements Dao<T> {

    EntityManager manager = EntityManagerUtil.getEntityManager();

    @Override
    public void delete(T objeto) {
        ejecutarEnTransaccion(manager -> manager.remove(objeto));
    }

    @Override
    public void update(T objeto) {
        ejecutarEnTransaccion(manager -> manager.merge(objeto));
    }

    @Override
    public void save(T objeto) {
        ejecutarEnTransaccion(manager -> manager.persist(objeto));
    }

    private void ejecutarEnTransaccion(Consumer<EntityManager> accion) {
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();
            accion.accept(manager);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        }
    }

    public EntityManager getEntityManager(){
        return manager;
    }
}
