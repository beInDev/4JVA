package com.fourjva.dao.base;

import java.io.Serializable;

public interface Dao<E,K extends Serializable> {
    E persist(E entity);
    void remove(E entity);
    public E update(E entity);
    E findById(K id);
}