package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public void delete(PK id) {
        entityManager.remove(entityManager.getReference(type, id));
    }

    @Override
    public T find(PK id) {
        return (T) entityManager.find(type, id);
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public List<T> all() {
        return null;
    }
}
