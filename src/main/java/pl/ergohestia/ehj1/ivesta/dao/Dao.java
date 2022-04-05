package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.entities.Vehicle;

import java.util.Collection;

public interface Dao<T> {

    T find(Long id);

    Collection<T> findAll();

    void save(T t);

    T update(T t);

    void delete(T t);
}