package org.grupocuatro.dao;

public interface Dao<T> {

    void delete(T t);

    void update(T t);

    void save(T t);
}
