package org.example.daointerfaces;

import java.util.List;

public interface Dao<T> {

    void insert(T t);
    void delete(T t);
    void update(T t);
    List<T> getAll();

}
