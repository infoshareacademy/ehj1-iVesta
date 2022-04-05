package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.model.DriverDto;

import java.util.Collection;

public interface Dao<T> {

    T find(Long id);

    Collection<T> findAll();

    DriverDto save(T t);

    T update(T t);

    void delete(T t);
}