package org.grupocuatro.dao;

import org.grupocuatro.utiles.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;

public abstract class AbstractDao<T> implements Dao<T> {

    EntityManager manager = EntityManagerUtil.getEntityManager();

    @Override
    public void delete(T t) {
        ejecutarEnTransaccion(manager -> manager.remove(t));
    }

    @Override
    public void update(T t) {
        ejecutarEnTransaccion(manager -> manager.merge(t));
    }

    @Override
    public void save(T t) {
        ejecutarEnTransaccion(manager -> manager.persist(t));
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
