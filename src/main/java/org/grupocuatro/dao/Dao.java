package org.grupocuatro.dao;

public interface Dao<T> {

    void delete(T objeto);

    void update(T objeto);

    void save(T objeto);
}
