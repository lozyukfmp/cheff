package by.netcracker.chef.dao.impl;

import by.netcracker.chef.dao.VegetableDao;
import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class VegetableDaoImpl extends GenericDaoImpl<Vegetable> implements VegetableDao {

    @Override
    public List<Vegetable> all() {
        return entityManager.createNamedQuery("Vegetable.findAll", Vegetable.class)
                .getResultList();
    }

}
